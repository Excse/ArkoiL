//
// Created by timo on 8/10/20.
//

#pragma once

#include <memory>

#include "../parser/allnodes.h"

class ScopeCheck {

public:
    ScopeCheck() = delete;

    ScopeCheck(const ScopeCheck &other) = delete;

    ScopeCheck &operator=(const ScopeCheck &) = delete;

public:
    static void visit(const SharedASTNode &node);

    static void visit(const SharedRootNode &rootNode);

    static void visit(const SharedImportNode &importNode);

    static void visit(const SharedFunctionNode &functionNode);

    static void visit(const SharedBlockNode &blockNode);

    static void visit(const SharedParameterNode &parameterNode);

    static void visit(const SharedVariableNode &variableNode);

    static void visit(const SharedIdentifierNode &identifierNode);

    static void visit(const SharedBinaryNode &binaryNode);

    static void visit(const SharedUnaryNode &unaryNode);

    static void visit(const SharedParenthesizedNode &parenthesizedNode);

    static void visit(const SharedStructCreateNode &structCreateNode);

    static void visit(const SharedStructArgumentNode &structArgumentNode);

    static void visit(const SharedFunctionArgumentNode &functionArgumentNode);

    static void visit(const SharedFunctionCallNode &functionCallNode);

    static void visit(const SharedAssignmentNode &assignmentNode);

    static void visit(const SharedReturnNode &returnNode);

    static void visit(const SharedStructNode &structNode);

private:
    template<class... Args>
    static void throwNode(unsigned int errorType, const SharedASTNode &node, Args... args);

};