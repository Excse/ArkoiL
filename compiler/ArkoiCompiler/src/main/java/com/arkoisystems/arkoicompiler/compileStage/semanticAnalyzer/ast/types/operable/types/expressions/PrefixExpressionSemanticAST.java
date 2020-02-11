package com.arkoisystems.arkoicompiler.compileStage.semanticAnalyzer.ast.types.operable.types.expressions;

import com.arkoisystems.arkoicompiler.compileStage.semanticAnalyzer.SemanticAnalyzer;
import com.arkoisystems.arkoicompiler.compileStage.semanticAnalyzer.ast.AbstractSemanticAST;
import com.arkoisystems.arkoicompiler.compileStage.semanticAnalyzer.ast.types.operable.AbstractOperableSemanticAST;
import com.arkoisystems.arkoicompiler.compileStage.syntaxAnalyzer.ast.ASTType;
import com.arkoisystems.arkoicompiler.compileStage.syntaxAnalyzer.ast.types.TypeSyntaxAST;
import com.arkoisystems.arkoicompiler.compileStage.syntaxAnalyzer.ast.types.operable.types.expression.types.PrefixExpressionSyntaxAST;
import lombok.Getter;
import lombok.Setter;

/**
 * Copyright © 2019 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiCompiler on the Sat Nov 09 2019 Author єхcsє#5543 aka timo
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * <p>
 * you may not use this file except in compliance with the License. You may obtain a copy
 * of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
@Getter
@Setter
public class PrefixExpressionSemanticAST extends AbstractOperableSemanticAST<PrefixExpressionSyntaxAST, TypeSyntaxAST.TypeKind>
{
    
    public PrefixExpressionSemanticAST(final AbstractSemanticAST<?> lastContainerAST, final PrefixExpressionSyntaxAST prefixExpressionSyntaxAST) {
        super(lastContainerAST, prefixExpressionSyntaxAST, ASTType.PREFIX_EXPRESSION);
    }
    
    @Override
    public PrefixExpressionSemanticAST analyse(final SemanticAnalyzer semanticAnalyzer) {
        return null;
    }
    
    @Override
    public TypeSyntaxAST.TypeKind prefixAdd(SemanticAnalyzer semanticAnalyzer) {
        return super.prefixAdd(semanticAnalyzer);
    }
    
    @Override
    public TypeSyntaxAST.TypeKind prefixSub(SemanticAnalyzer semanticAnalyzer) {
        return super.prefixSub(semanticAnalyzer);
    }
    
    @Override
    public TypeSyntaxAST.TypeKind prefixNegate(SemanticAnalyzer semanticAnalyzer) {
        return super.prefixNegate(semanticAnalyzer);
    }
    
    @Override
    public TypeSyntaxAST.TypeKind prefixAffirm(SemanticAnalyzer semanticAnalyzer) {
        return super.prefixAffirm(semanticAnalyzer);
    }
    
}
