/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiCompiler on March 02, 2020
 * Author timo aka. єхcsє#5543
 */
package com.arkoisystems.arkoicompiler.stage.semanticAnalyzer;

public class SemanticErrorType
{
    
    public final static String FUNCTION_DESC_ALREADY_EXISTS = "There already exists another function with the same name and arguments:";
    public final static String FUNCTION_ANNOTATION_SAME_NAME = "This function already has another annotation with the same name:";
    public final static String FUNCTION_ARGUMENT_SAME_NAME = "There already exists another arguments with the same name:";
    public final static String FUNCTION_NO_SUCH_FUNCTION = "There doesn't exists any function with this name and arguments:";
    
    public final static String IMPORT_NAME_ALREADY_TAKEN = "There already exists %s with the same name:";
    public final static String IMPORT_INVALID_PATH = "The specified path doesn't lead to an valid arkoi file:";
    
    public final static String BLOCK_INLINE_EXPRESSION = "You can't add any other ASTs besides an Expression to an inlined block:";
    public final static String BLOCK_AST_NOT_SUPPORTED = "The declared AST inside the block is not supported currently:";
    
    public final static String VARIABLE_ANNOTATION_SAME_NAME = "This variable already has another annotation with the same name:";
    public final static String VARIABLE_NAME_ALREADY_TAKEN = "There already exists %s with the same name:";
    
    public final static String BINARY_ADDITION_NOT_SUPPORTED = "Addition isn't supported by these operable.";
    public final static String BINARY_SUBTRACTION_NOT_SUPPORTED = "Subtraction isn't supported by these operable.";
    public final static String BINARY_MULTIPLICATION_NOT_SUPPORTED = "Multiplication isn't supported by these operable.";
    public final static String BINARY_DIVISION_NOT_SUPPORTED = "Division isn't supported by these operable.";
    public final static String BINARY_MODULO_NOT_SUPPORTED = "Modulo isn't supported by these operable.";
    public final static String BINARY_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the binary expression:";
    public final static String BINARY_ADDITION_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the binary addition operator:";
    public final static String BINARY_SUBTRACTION_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the binary subtraction operator:";
    public final static String BINARY_MULTIPLICATION_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the binary multiplication operator:";
    public final static String BINARY_DIVISION_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the binary division operator:";
    public final static String BINARY_MODULO_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the binary modular operator:";
    public final static String BINARY_EXPONENTIAL_NOT_SUPPORTED =  "The operable isn't supported by the binary exponential operator:";
    public final static String BINARY_EXPONENTIAL_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the binary division operator:";
    
    public final static String ASSIGN_ASSIGNMENT_NOT_SUPPORTED = "Assignment isn't supported by these operable.";
    public final static String ASSIGN_ADD_ASSIGNMENT_NOT_SUPPORTED = "Addition assignment isn't supported by these operable.";
    public final static String ASSIGN_SUB_ASSIGNMENT_NOT_SUPPORTED = "Subtraction assignment isn't supported by these operable.";
    public final static String ASSIGN_MUL_ASSIGNMENT_NOT_SUPPORTED = "Multiplication assignment isn't supported by these operable.";
    public final static String ASSIGN_DIV_ASSIGNMENT_NOT_SUPPORTED = "Division assignment isn't supported by these operable.";
    public final static String ASSIGN_MOD_ASSIGNMENT_NOT_SUPPORTED = "Modulo assignment isn't supported by these operable.";
    public final static String ASSIGN_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the assignment expression:";
    public final static String ASSIGN_ASSIGNMENT_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the assign operator";
    public final static String ASSIGN_ADD_ASSIGNMENT_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the addition assignment operator:";
    public final static String ASSIGN_SUB_ASSIGNMENT_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the subtract assignment operator:";
    public final static String ASSIGN_MUL_ASSIGNMENT_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the multiplication assignment operator:";
    public final static String ASSIGN_DIV_ASSIGNMENT_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the division assignment operator:";
    public final static String ASSIGN_MOD_ASSIGNMENT_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the modular assignment operator:";
    
    public final static String EQUAL_NOT_SUPPORTED = "The \"equal\" operation isn't supported by these operable.";
    public final static String NOT_EQUAL_NOT_SUPPORTED = "The \"not equal\" operation isn't supported by these operable.";
    
    public final static String LOGICAL_OR_NOT_SUPPORTED = "The \"logical or\" operation isn't supported by these operable.";
    public final static String LOGICAL_AND_NOT_SUPPORTED = "The \"logical and\" operation isn't supported by these operable.";
    
    public final static String POSTFIX_ADD_NOT_SUPPORTED = "The \"post addition\" operator isn't supported by this operable.";
    public final static String POSTFIX_SUB_NOT_SUPPORTED = "The \"post subtraction\" operator isn't supported by this operable.";
    public final static String POSTFIX_SUB_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the post-subtraction operation:";
    public final static String POSTFIX_ADD_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the post-addition operation:";
    public final static String POSTFIX_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the postfix expression:";
    
    public final static String PREFIX_ADD_NOT_SUPPORTED = "The \"pre addition\" operator isn't supported by this operable.";
    public final static String PREFIX_SUB_NOT_SUPPORTED = "The \"pre subtraction\" operator isn't supported by this operable.";
    public final static String PREFIX_NEGATE_NOT_SUPPORTED = "The \"negate\" operator isn't supported by this operable.";
    public final static String PREFIX_AFFIRM_NOT_SUPPORTED = "The \"affirm\" operator isn't supported by this operable.";
    public final static String PREFIX_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the prefix expression:";
    public final static String PREFIX_ADD_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the pre-addition operation:";
    public final static String PREFIX_SUB_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the pre-subtraction operation:";
    public final static String PREFIX_NEGATE_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the negate operation:";
    public final static String PREFIX_AFFIRM_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the affirm operation:";
    
    public final static String RELATIONAL_LESS_THAN_NOT_SUPPORTED = "The \"less than\" operator isn't supported by these operable.";
    public final static String RELATIONAL_GREATER_THAN_NOT_SUPPORTED = "The \"greater than\" operator isn't supported by these operable.";
    public final static String RELATIONAL_LESS_EQUAL_THAN_NOT_SUPPORTED = "The \"less equal than\" operator isn't supported by these operable.";
    public final static String RELATIONAL_GREATER_EQUAL_THAN_NOT_SUPPORTED = "The \"greater equal than\" operator isn't supported by these operable.";
    public final static String RELATIONAL_IS_NOT_SUPPORTED = "The \"is\" keyword isn't supported by these operable.";
    
    public final static String EXPRESSION_AST_NOT_SUPPORTED = "This AST isn't supported by an expression:";
    
    public final static String STRING_NO_OPERABLE = "The operable string isn't declared. Please contact the developer if this error occurred.";
    
    public final static String IDENTIFIER_CALL_AST_NOT_SUPPORTED = "The found identifier isn't supported by the identifier call operation:";
    public final static String IDENTIFIER_CALL_NO_SUCH_IDENTIFIER = "No identifier with the same name could be found:";
    
    public final static String IDENTIFIER_INVOKE_NO_SUCH_IDENTIFIER = "No identifier with the same name could be found:";
    public final static String IDENTIFIER_INVOKE_IMPORT_NOT_VALID = "The identifier invoke couldn't be checked because the import isn't valid.";
    public final static String IDENTIFIER_INVOKE_STATEMENT_NOT_SUPPORTED = "The invoked statement isn't supported by the identifier invoke operation:";
    
    public final static String CAST_OPERABLE_NOT_SUPPORTED = "The operable isn't supported by the cast expression:";
    
}
