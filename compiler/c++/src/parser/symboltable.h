//
// Created by timo on 8/7/20.
//

#ifndef ARKOICOMPILER_SYMBOLTABLE_H
#define ARKOICOMPILER_SYMBOLTABLE_H

#include <unordered_map>
#include <functional>
#include <memory>
#include <vector>

class ASTNode;

class SymbolTable {

    typedef std::vector<std::shared_ptr<ASTNode>> Symbols;
    typedef std::unordered_map<std::string, Symbols> Table;
    typedef std::function<bool(const std::shared_ptr<ASTNode> &)> Predicate;

public:
    std::shared_ptr<SymbolTable> parent;
    Table table;

public:
    explicit SymbolTable(const std::shared_ptr<SymbolTable> &parent);

    SymbolTable(const SymbolTable &other) = default;

public:
    std::shared_ptr<SymbolTable::Symbols> all(const std::string &id,
                                              const SymbolTable::Predicate &predicate);

    std::shared_ptr<SymbolTable::Symbols> scope(const std::string &id,
                                                const SymbolTable::Predicate &predicate);

    void insert(const std::string &id, const std::shared_ptr<ASTNode> &node);

};

#endif //ARKOICOMPILER_SYMBOLTABLE_H
