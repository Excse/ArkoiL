/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiCompiler on March 03, 2020
 * Author timo aka. єхcsє#5543
 */
package com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer;

public class SyntaxErrorType
{
    
    public static String TYPE_DOES_NOT_START_WITH_IDENTIFIER = "Couldn't parse the Type because the parsing doesn't start with an IdentifierToken.";
    public static String TYPE_NOT_A_VALID_TYPE = "Couldn't parse the Type because it isn't a valid type keyword.";
    
    public static String ROOT_INLINED_FUNCTION_HAS_WRONG_ENDING = "Couldn't parse the \"function definition\" statement because the inlined function doesn't end with a semicolon.";
    public static String ROOT_BLOCK_FUNCTION_HAS_WRONG_ENDING = "Couldn't parse the \"function definition\" statement because it doesn't end with a closing brace.";
    public static String ROOT_STATEMENT_HAS_WRONG_ENDING = "Couldn't parse the \"%s\" because it doesn't end with a semicolon.";
    public static String ROOT_NO_PARSER_FOUND = "Couldn't parse the AST because no parser could parse this token. Check for misspelling or something else.";
    
    public static String BLOCK_BLOCK_HAS_WRONG_ENDING = "Couldn't parse the \"BlockAST\" because it doesn't end with a closing brace.";
    public static String BLOCK_STATEMENT_HAS_WRONG_ENDING = "Couldn't parse the \"%s\" because it doesn't end with a semicolon.";
    public static String BLOCK_NO_PARSER_FOUND = "Couldn't parse the AST because no parser could parse this token. Check for misspelling or something else.";
    public static String BLOCK_NO_VALID_EXPRESSION = "Couldn't parse the BlockAST because the equal sign isn't followed by an valid expression.";
    public static String BLOCK_INLINED_BLOCK_WRONG_ENDING = "Couldn't parse the BlockAST because the inlined block doesn't end with a semicolon.";
    public static String BLOCK_INVALID_SEPARATOR = "Couldn't parse the BlockAST because the parsing doesn't start with an opening brace or equal sign to identify the block type.";
    public static String BLOCK_WRONG_START = "Couldn't parse the BlockAST because it isn't declared inside a function/variable definition or block.";
    
    public static String ARGUMENT_WRONG_START = "Couldn't parse the argument definition because the parsing doesn't start with an identifier as name.";
    public static String ARGUMENT_NO_SEPARATOR = "Couldn't parse the argument definition because the argument name isn't followed by a colon.";
    public static String ARGUMENT_NO_VALID_TYPE = "Couldn't parse the argument definition because the colon isn't followed by a valid type.";
    
    public static String VARIABLE_DEFINITION_WRONG_PARENT = "Couldn't parse the \"variable definition\" statement because it isn't declared inside the root file or in a block.";
    public static String VARIABLE_DEFINITION_WRONG_STAR = "Couldn't parse the \"variable definition\" statement because the parsing doesn't start with the \"var\" keyword.";
    public static String VARIABLE_DEFINITION_NO_NAME = "Couldn't parse the \"variable definition\" statement because the \"var\" keyword isn't followed by an variable name.";
    public static String VARIABLE_DEFINITION_NO_EQUAL_SIGN = "Couldn't parse the \"variable definition\" statement because the variable name isn't followed by an equal sign for deceleration of the following expression.";
    public static String VARIABLE_DEFINITION_ERROR_DURING_EXPRESSION_PARSING = "Couldn't parse the \"variable definition\" statement because the equal sign is followed by an invalid expression.";
    public static String VARIABLE_DEFINITION_WRONG_ENDING = "Couldn't parse the \"variable definition\" statement because it doesn't end with an semicolon.";
    
    public static String IMPORT_DEFINITION_WRONG_PARENT = "Couldn't parse the \"import\" statement because it isn't declared inside the root file.";
    public static String IMPORT_DEFINITION_WRONG_START = "Couldn't parse the \"import\" statement because the parsing doesn't start with the \"import\" keyword.";
    public static String IMPORT_DEFINITION_NO_FILEPATH = "Couldn't parse the \"import\" statement because the \"import\" keyword isn't followed by an file path.";
    public static String IMPORT_DEFINITION_NOT_FOLLOWED_BY_NAME = "Couldn't parse the \"import\" statement because the \"named\" keyword isn't followed by an name identifier.";
    public static String IMPORT_DEFINITION_WRONG_ENDING = "Couldn't parse the \"import\" statement because it doesn't end with a semicolon.";
    
    public static String THIS_STATEMENT_WRONG_PARENT = "Couldn't parse the \"this\" statement because it isn't declared inside a block or an expression.";
    public static String THIS_STATEMENT_WRONG_START = "Couldn't parse the \"this\" statement because the parsing doesn't start with the \"this\" keyword.";
    public static String THIS_STATEMENT_NO_SEPARATOR = "Couldn't parse the \"this\" statement because the \"this\" keyword isn't followed by an period.";
    public static String THIS_STATEMENT_NO_VALID_STATEMENT = "Couldn't parse the \"this\" statement because the period isn't followed by a valid statement.";
    
    public static String RETURN_STATEMENT_WRONG_PARENT = "Couldn't parse the \"return\" statement because it isn't declared inside a block.";
    public static String RETURN_STATEMENT_WRONG_START = "Couldn't parse the \"return\" statement because the parsing doesn't start with the \"return\" keyword.";
    public static String RETURN_STATEMENT_NO_VALID_EXPRESSION = "Couldn't parse the \"return\" statement because the keyword isn't followed by an valid expression.";
    public static String RETURN_STATEMENT_WRONG_ENDING = "Couldn't parse the \"return\" statement because it doesn't end with a semicolon.";
    
    public static String FUNCTION_DEFINITION_WRONG_PARENT = "Couldn't parse the \"function definition\" statement because it isn't declared inside the root file.";
    public static String FUNCTION_DEFINITION_WRONG_START = "Couldn't parse the \"function definition\" statement because the parsing doesn't start with the \"fun\" keyword.";
    public static String FUNCTION_DEFINITION_NO_NAME = "Couldn't parse the \"function definition\" statement because the \"fun\" keyword isn't followed by a function name.";
    public static String FUNCTION_DEFINITION_WRONG_RETURN_TYPE_START = "Couldn't parse the \"function definition\" statement because the function name isn't followed by an opening sign aka. \"<\".";
    public static String FUNCTION_DEFINITION_WRONG_RETURN_TYPE_ENDING = "Couldn't parse the \"function definition\" statement because the return type section doesn't end with a closing sign aka. \">\".";
    public static String FUNCTION_DEFINITION_WRONG_ARGUMENTS_START = "Couldn't parse the \"function definition\" statement because the argument section doesn't start with an opening parenthesis.";
    public static String FUNCTION_DEFINITION_WRONG_ARGUMENTS_ENDING = "Couldn't parse the \"function definition\" statement because the argument section doesn't end with a closing parenthesis.";
    public static String FUNCTION_DEFINITION_WRONG_NATIVE_ENDING = "Couldn't parse the \"function definition\" statement because a native function needs to end direclty with an semicolon after the argument section.";
    public static String FUNCTION_DEFINITION_WRONG_BLOCK_START = "Couldn't parse the \"function definition\" statement because after the argument section no opening brace or equal sign was declared. You need one of them to declare if this function uses a block or is inlined.";
    public static String FUNCTION_DEFINITION_NO_VALID_BLOCK = "Couldn't parse the \"function definition\" statement because the block separator isn't followed by a valid block.";
    public static String FUNCTION_DEFINITION_WRONG_INLINED_BLOCK_ENDING = "Couldn't parse the \"function definition\" statement because an inlined function needs to end with a semicolon.";
    public static String FUNCTION_DEFINITION_WRONG_BLOCK_ENDING = "Couldn't parse the \"function definition\" statement because a block needs to end with a closing brace aka. \"}\".";
    
    public static String OPERABLE_UNSUPPORTED_SYMBOL_TYPE = "Couldn't parse the operable because the SymbolType isn't supported.";
    public static String OPERABLE_IDENTIFIER_NOT_PARSEABLE = "Couldn't parse the operable statement because it isn't parsable.";
    public static String OPERABLE_UNSUPPORTED_STATEMENT = "Couldn't parse the operable because it isn't a supported statement.";
    
    public static String STRING_OPERABLE_NO_STRING = "Couldn't parse the string operable because the parsing doesn't start with a string.";
    
    public static String NUMBER_OPERABLE_NO_NUMBER = "Couldn't parse the number operable because the parsing doesn't start with a number.";
    
    public static String IDENTIFIER_INVOKE_WRONG_START = "Couldn't parse the \"identifier invoke\" statement because the parsing doesn't start with an identifier.";
    public static String IDENTIFIER_INVOKE_NO_SEPARATOR = "Couldn't parse the \"identifier invoke\" statement because the name isn't followed by an period.";
    public static String IDENTIFIER_INVOKE_NO_VALID_STATEMENT = "Couldn't parse the \"identifier invoke\" statement because the period isn't followed by an valid statement.";
    
    public static String IDENTIFIER_CALL_NO_IDENTIFIER = "Couldn't parse the \"identifier call\" statement because the parsing doesn't start with an Identifier.";
    
    public static String FUNCTION_INVOKE_WRONG_PARENT = "Couldn't parse the \"function invoke\" statement because it isn't declared inside a block, variable invocation or an expression.";
    public static String FUNCTION_INVOKE_WRONG_START = "Couldn't parse the \"function invoke\" statement because the parsing doesn't start with the valid function name.";
    public static String FUNCTION_INVOKE_WRONG_ARGUMENTS_START = "Couldn't parse the \"function invoke\" statement because the function name isn't followed by an opening parenthesis. To invoke function you need to add parenthesis because it is necessary to differentiate between functions and variables.";
    public static String FUNCTION_INVOKE_ARGUMENT_NOT_PARSEABLE = "Couldn't parse the \"function invoke\" statement because there is incorrect syntax of an expression inside the parenthesis.";
    public static String FUNCTION_INVOKE_NO_SEPARATOR = "Couldn't parse the \"function invoke\" statement because an expression isn't followed by an comma or an closing parenthesis.";
    public static String FUNCTION_INVOKE_WRONG_ARGUMENTS_ENDING = "Couldn't parse the \"function invoke\" statement because the expression section isn't ended with an closing parenthesis.";
    public static String FUNCTION_INVOKE_WRONG_ENDING = "Couldn't parse the \"function invoke\" statement because it doesn't end with a semicolon but is used as a block invocation.";
    
    public static String COLLECTION_OPERABLE_WRONG_START = "Couldn't parse the collection operable because the parsing doesn't start with an opening bracket.";
    public static String COLLECTION_OPERABLE_INVALID_EXPRESSION = "Couldn't parse the collection operable because there is an invalid expression inside.";
    public static String COLLECTION_OPERABLE_WRONG_ENDING = "Couldn't parse the collection operable because it doesn't end with an closing bracket.";
    
}
