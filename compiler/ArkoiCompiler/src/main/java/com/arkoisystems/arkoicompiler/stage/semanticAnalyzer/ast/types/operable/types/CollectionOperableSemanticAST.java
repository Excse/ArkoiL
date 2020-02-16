/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiCompiler on February 15, 2020
 * Author timo aka. єхcsє#5543
 */
package com.arkoisystems.arkoicompiler.stage.semanticAnalyzer.ast.types.operable.types;

import com.arkoisystems.arkoicompiler.stage.semanticAnalyzer.SemanticAnalyzer;
import com.arkoisystems.arkoicompiler.stage.semanticAnalyzer.ast.AbstractSemanticAST;
import com.arkoisystems.arkoicompiler.stage.semanticAnalyzer.ast.types.operable.AbstractOperableSemanticAST;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.utils.ASTType;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.types.operable.types.CollectionOperableSyntaxAST;
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.utils.TypeKind;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CollectionOperableSemanticAST extends AbstractOperableSemanticAST<CollectionOperableSyntaxAST, TypeKind>
{
    
    public CollectionOperableSemanticAST(final SemanticAnalyzer semanticAnalyzer, final AbstractSemanticAST<?> lastContainerAST, final CollectionOperableSyntaxAST collectionOperableSyntaxAST) {
        super(semanticAnalyzer, lastContainerAST, collectionOperableSyntaxAST, ASTType.COLLECTION_OPERABLE);
    }
    
    @Override
    public TypeKind getExpressionType() {
        return TypeKind.COLLECTION;
    }
    
    //    @Override
//    public CollectionOperableSemanticAST analyseAST(final SemanticAnalyzer semanticAnalyzer) {
//        System.out.println("Collection Operable Semantic AST");
//        return null;
//    }
    
}
