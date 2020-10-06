//
// Created by timo on 7/30/20.
//

#pragma once

#include <utility>
#include <vector>
#include <memory>
#include <set>

class Token;

class ASTNode;

class RootNode;

class ImportNode;

class FunctionNode;

class ParameterNode;

class TypeNode;

class BlockNode;

class VariableNode;

class OperableNode;

class IdentifierNode;

class ReturnNode;

class StructNode;

class FunctionArgumentNode;

class SymbolTable;

class TypedNode;

class FunctionCallNode;

class StructCreateNode;

class Parser {

private:
    std::vector<std::shared_ptr<Token>> m_Tokens;
    std::string m_SourceCode, m_SourcePath;
    unsigned int m_Position;

public:
    Parser(std::string sourcePath, std::string sourceCode,
           std::vector<std::shared_ptr<Token>> tokens);

    Parser(const Parser &other) = delete;

    Parser &operator=(const Parser &) = delete;

public:
    std::shared_ptr<RootNode> parseRoot();

private:
    std::shared_ptr<ImportNode> parseImport(const std::shared_ptr<ASTNode> &parent);

    std::shared_ptr<FunctionNode> parseFunction(const std::set<std::string> &annotations,
                                                const std::shared_ptr<ASTNode> &parent);

    std::shared_ptr<ParameterNode> parseParameter(const std::shared_ptr<ASTNode> &parent);

    std::shared_ptr<TypeNode> parseType(const std::shared_ptr<ASTNode> &parent);

    std::shared_ptr<BlockNode> parseBlock(const std::shared_ptr<ASTNode> &parent,
                                          const std::shared_ptr<SymbolTable>& scope);

    std::shared_ptr<VariableNode> parseVariable(const std::shared_ptr<ASTNode> &parent,
                                                const std::shared_ptr<SymbolTable>& scope);

    std::shared_ptr<OperableNode> parseRelational(const std::shared_ptr<ASTNode> &parent);

    std::shared_ptr<OperableNode> parseAdditive(const std::shared_ptr<ASTNode> &parent);

    std::shared_ptr<OperableNode> parseMultiplicative(const std::shared_ptr<ASTNode> &parent);

    std::shared_ptr<OperableNode> parseCast(const std::shared_ptr<ASTNode> &parent);

    std::shared_ptr<OperableNode> parseOperable(const std::shared_ptr<ASTNode> &parent);

    std::shared_ptr<OperableNode> parseIdentifier(const std::shared_ptr<ASTNode> &parent);

    std::shared_ptr<ReturnNode> parseReturn(const std::shared_ptr<ASTNode> &parent);

    std::shared_ptr<StructNode> parseStruct(const std::shared_ptr<ASTNode> &parent);

    std::set<std::string> parseAnnotations(const std::shared_ptr<ASTNode> &parent);

    void parseFunctionArguments(std::shared_ptr<FunctionCallNode> &functionCallNode,
                                const std::shared_ptr<ASTNode> &parent);

    void parseStructArguments(std::shared_ptr<StructCreateNode> &structCreateNode,
                              const std::shared_ptr<ASTNode> &parent);

    std::shared_ptr<Token> peekToken(int offset, bool advance = true, bool safety = true);

    std::shared_ptr<Token> nextToken(int times = 1, bool advance = true, bool safety = true);

    std::shared_ptr<Token> undoToken(int times = 1, bool advance = true, bool safety = true);

    std::shared_ptr<Token> currentToken(bool safety = true);

};