/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiCompiler on February 15, 2020
 * Author timo aka. єхcsє#5543
 */
package com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.types.operable.types;

import com.arkoisystems.arkoicompiler.stage.lexcialAnalyzer.token.types.StringToken;
import com.arkoisystems.arkoicompiler.stage.lexcialAnalyzer.token.utils.TokenType;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.SyntaxAnalyzer;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.SyntaxErrorType;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.AbstractSyntaxAST;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.types.operable.AbstractOperableSyntaxAST;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.utils.ASTType;

import java.io.PrintStream;

public class StringOperableSyntaxAST extends AbstractOperableSyntaxAST<StringToken>
{
    
    public StringOperableSyntaxAST(final SyntaxAnalyzer syntaxAnalyzer) {
        super(syntaxAnalyzer, ASTType.STRING_OPERABLE);
    }
    
    
    @Override
    public StringOperableSyntaxAST parseAST(final AbstractSyntaxAST parentAST) {
        if (this.getSyntaxAnalyzer().matchesCurrentToken(TokenType.STRING_LITERAL) == null) {
            this.addError(
                    this.getSyntaxAnalyzer().getArkoiClass(),
                    this.getSyntaxAnalyzer().currentToken(),
                    SyntaxErrorType.STRING_OPERABLE_NO_STRING
            );
            return null;
        }
        
        this.setOperableObject((StringToken) this.getSyntaxAnalyzer().currentToken());
        this.setStart(this.getOperableObject().getStart());
        this.setEnd(this.getOperableObject().getEnd());
        return this;
    }
    
    
    @Override
    public void printSyntaxAST(final PrintStream printStream, final String indents) {
        printStream.println(indents + "└── operable: " + this.getOperableObject().getTokenContent());
    }
    
}
