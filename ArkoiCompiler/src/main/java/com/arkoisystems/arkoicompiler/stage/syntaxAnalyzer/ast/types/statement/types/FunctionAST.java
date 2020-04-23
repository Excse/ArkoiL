/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiCompiler on February 15, 2020
 * Author єхcsє#5543 aka timo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.types.statement.types;

import com.arkoisystems.arkoicompiler.api.IASTNode;
import com.arkoisystems.arkoicompiler.api.IToken;
import com.arkoisystems.arkoicompiler.api.IVisitor;
import com.arkoisystems.arkoicompiler.stage.lexcialAnalyzer.token.types.BadToken;
import com.arkoisystems.arkoicompiler.stage.lexcialAnalyzer.token.types.IdentifierToken;
import com.arkoisystems.arkoicompiler.stage.lexcialAnalyzer.token.types.TypeKeywordToken;
import com.arkoisystems.arkoicompiler.stage.lexcialAnalyzer.token.utils.KeywordType;
import com.arkoisystems.arkoicompiler.stage.lexcialAnalyzer.token.utils.SymbolType;
import com.arkoisystems.arkoicompiler.stage.lexcialAnalyzer.token.utils.TokenType;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.SyntaxAnalyzer;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.SyntaxErrorType;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.types.AnnotationAST;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.types.BlockAST;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.types.ParameterListAST;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.types.TypeAST;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.types.statement.StatementAST;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.utils.ASTType;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.utils.BlockType;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.utils.TypeKind;
import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FunctionAST extends StatementAST
{
    
    
    @Getter
    @NotNull
    private final List<AnnotationAST> functionAnnotations;
    
    
    @Getter
    @Nullable
    private IdentifierToken functionName;
    
    
    @Getter
    @Nullable
    private TypeAST functionReturnType;
    
    
    @Getter
    @Nullable
    private ParameterListAST functionParameters;
    
    
    @Getter
    @Nullable
    private BlockAST functionBlock;
    
    
    @Builder
    protected FunctionAST(
            @Nullable final List<AnnotationAST> functionAnnotations,
            @Nullable final ParameterListAST functionParameters,
            @Nullable final SyntaxAnalyzer syntaxAnalyzer,
            @Nullable final IdentifierToken functionName,
            @Nullable final TypeAST functionReturnType,
            @Nullable final BlockAST functionBlock,
            @Nullable final IToken startToken,
            @Nullable final IToken endToken
    ) {
        super(syntaxAnalyzer, ASTType.FUNCTION, startToken, endToken);
        
        this.functionAnnotations = functionAnnotations == null ? new ArrayList<>() : functionAnnotations;
        this.functionParameters = functionParameters;
        this.functionReturnType = functionReturnType;
        this.functionBlock = functionBlock;
        this.functionName = functionName;
    }
    
    
    @NotNull
    @Override
    public FunctionAST parseAST(@NotNull final IASTNode parentAST) {
        Objects.requireNonNull(this.getSyntaxAnalyzer(), "syntaxAnalyzer must not be null.");
        
        if (this.getSyntaxAnalyzer().matchesCurrentToken(KeywordType.FUN) == null)
            return this.addError(
                    this,
                    this.getSyntaxAnalyzer().getCompilerClass(),
                    this.getSyntaxAnalyzer().currentToken(),
                    
                    SyntaxErrorType.SYNTAX_ERROR_TEMPLATE,
                    "Function", "'fun'", this.getSyntaxAnalyzer().currentToken().getTokenContent()
            );
        
        this.startAST(this.getSyntaxAnalyzer().currentToken());
        
        if (this.getSyntaxAnalyzer().matchesPeekToken(1, TokenType.IDENTIFIER) == null)
            return this.addError(
                    this,
                    this.getSyntaxAnalyzer().getCompilerClass(),
                    this.getSyntaxAnalyzer().currentToken(),
                    
                    SyntaxErrorType.SYNTAX_ERROR_TEMPLATE,
                    "Function", "<identifier>", this.getSyntaxAnalyzer().currentToken().getTokenContent()
            );
        
        this.functionName = (IdentifierToken) this.getSyntaxAnalyzer().nextToken();
        
        if (this.getSyntaxAnalyzer().matchesPeekToken(1, SymbolType.OPENING_ARROW) == null)
            return this.addError(
                    this,
                    this.getSyntaxAnalyzer().getCompilerClass(),
                    this.getSyntaxAnalyzer().currentToken(),
                    
                    SyntaxErrorType.SYNTAX_ERROR_TEMPLATE,
                    "Function", "'<'", this.getSyntaxAnalyzer().currentToken().getTokenContent()
            );
        
        this.getSyntaxAnalyzer().nextToken(2);
        
        if (TypeAST.TYPE_PARSER.canParse(this, this.getSyntaxAnalyzer())) {
            final TypeAST typeAST = TypeAST.TYPE_PARSER.parse(this, this.getSyntaxAnalyzer());
            this.getMarkerFactory().addFactory(typeAST.getMarkerFactory());
    
            if (typeAST.isFailed()) {
                this.failed();
                return this;
            }
    
            this.functionReturnType = typeAST;
            this.getSyntaxAnalyzer().nextToken();
        } else this.functionReturnType = TypeAST.builder()
                .syntaxAnalyzer(this.getSyntaxAnalyzer())
                .typeKeywordToken(TypeKeywordToken.builder()
                        .lexicalAnalyzer(this.getSyntaxAnalyzer().getCompilerClass().getLexicalAnalyzer())
                        .typeKind(TypeKind.VOID)
                        .build()
                )
                .startToken(BadToken.builder()
                        .lexicalAnalyzer(this.getSyntaxAnalyzer().getCompilerClass().getLexicalAnalyzer())
                        .build()
                )
                .endToken(BadToken.builder()
                        .lexicalAnalyzer(this.getSyntaxAnalyzer().getCompilerClass().getLexicalAnalyzer())
                        .build()
                )
                .isArray(false)
                .build();
        
        if (this.getSyntaxAnalyzer().matchesCurrentToken(SymbolType.CLOSING_ARROW) == null)
            return this.addError(
                    this,
                    this.getSyntaxAnalyzer().getCompilerClass(),
                    this.getSyntaxAnalyzer().currentToken(),
                    
                    SyntaxErrorType.SYNTAX_ERROR_TEMPLATE,
                    "Function", "'>'", this.getSyntaxAnalyzer().currentToken().getTokenContent()
            );
        
        if (this.getSyntaxAnalyzer().matchesPeekToken(1, SymbolType.OPENING_PARENTHESIS) == null)
            return this.addError(
                    this,
                    this.getSyntaxAnalyzer().getCompilerClass(),
                    this.getSyntaxAnalyzer().currentToken(),
                    
                    SyntaxErrorType.SYNTAX_ERROR_TEMPLATE,
                    "Function", "'('", this.getSyntaxAnalyzer().currentToken().getTokenContent()
            );
        
        this.getSyntaxAnalyzer().nextToken();
        
        final ParameterListAST parameterListAST = ParameterListAST.builder()
                .syntaxAnalyzer(this.getSyntaxAnalyzer())
                .build()
                .parseAST(this);
        this.getMarkerFactory().addFactory(parameterListAST.getMarkerFactory());
        
        if (parameterListAST.isFailed()) {
            this.failed();
            return this;
        }
        
        this.functionParameters = parameterListAST;
        
        if (this.getSyntaxAnalyzer().matchesCurrentToken(SymbolType.CLOSING_PARENTHESIS) == null)
            return this.addError(
                    this,
                    this.getSyntaxAnalyzer().getCompilerClass(),
                    this.getSyntaxAnalyzer().currentToken(),
                    
                    SyntaxErrorType.SYNTAX_ERROR_TEMPLATE,
                    "Function", "')'", this.getSyntaxAnalyzer().currentToken().getTokenContent()
            );
        
        this.getSyntaxAnalyzer().nextToken();
        
        if (this.hasAnnotation("native")) {
            this.setEndToken(this.getSyntaxAnalyzer().currentToken());
            this.getMarkerFactory().done(this.getEndToken());
    
            this.functionBlock = BlockAST.builder()
                    .syntaxAnalyzer(this.getSyntaxAnalyzer())
                    .blockType(BlockType.NATIVE)
                    .startToken(this.getStartToken())
                    .endToken(this.getEndToken())
                    .build();
            return this;
        }
        
        if (!BlockAST.BLOCK_PARSER.canParse(this, this.getSyntaxAnalyzer()))
            return this.addError(
                    this,
                    this.getSyntaxAnalyzer().getCompilerClass(),
                    this.getSyntaxAnalyzer().currentToken(),
                    
                    SyntaxErrorType.SYNTAX_ERROR_TEMPLATE,
                    "Function", "'block'", this.getSyntaxAnalyzer().currentToken().getTokenContent()
            );
        
        final BlockAST blockAST = BlockAST.BLOCK_PARSER.parse(this, this.getSyntaxAnalyzer());
        this.getMarkerFactory().addFactory(blockAST.getMarkerFactory());
        
        if (blockAST.isFailed()) {
            this.failed();
            return this;
        }
        
        this.functionBlock = blockAST;
        
        this.endAST(this.getSyntaxAnalyzer().currentToken());
        return this;
    }
    
    
    @Override
    public void accept(@NotNull final IVisitor<?> visitor) {
        visitor.visit(this);
    }
    
    
    @Override
    public @NotNull TypeKind getTypeKind() {
        Objects.requireNonNull(this.getFunctionReturnType(), "functionReturnType must not be null.");
        
        return this.getFunctionReturnType().getTypeKind();
    }
    
    
    public String getFunctionDescription() {
        Objects.requireNonNull(this.getFunctionName(), "functionName must not be null.");
        Objects.requireNonNull(this.getFunctionParameters(), "functionParameters must not be null.");
        
        return this.getFunctionName().getTokenContent() + "(" + this.getFunctionParameters().getParameters().size() + ")";
    }
    
    
    public boolean hasAnnotation(@NotNull final String annotationName) {
        for (final AnnotationAST annotationAST : this.functionAnnotations) {
            if (annotationAST.getAnnotationName() == null)
                continue;
            if (annotationAST.getAnnotationName().getTokenContent().equals(annotationName))
                return true;
        }
        return false;
    }
    
}
