//
// Created by timo on 7/31/20.
//

#include "error.h"

#include <iostream>
#include <utility>

#include "../utils.h"

Error::Error(std::string sourcePath, std::string sourceCode, unsigned int startLine,
             unsigned int endLine, unsigned int startChar, unsigned int endChar,
             std::string causeMessage)
        : m_CauseMessage(std::move(causeMessage)), m_SourcePath(std::move(sourcePath)),
          m_SourceCode(std::move(sourceCode)), m_StartLine(startLine),
          m_EndLine(endLine), m_StartChar(startChar),
          m_EndChar(endChar) {}

std::ostream &operator<<(std::ostream &out, const Error &error) {
    out << error.m_SourcePath << ":" << (error.m_StartLine + 1) << " "
        << error.m_CauseMessage << std::endl;

    std::vector<std::string> lines;
    Utils::split(error.m_SourceCode, lines, '\n');

    unsigned int startLineChar = 0;
    unsigned int endLineChar = 0;
    for (auto lineIndex = 0; lineIndex < error.m_EndLine; lineIndex++) {
        if (lineIndex < error.m_StartLine)
            startLineChar += lines[lineIndex].size() + 1;
        endLineChar += lines[lineIndex].size() + 1;
    }

    auto startLineDifference = error.m_StartChar - startLineChar;
    auto endLineDifference = error.m_EndChar - endLineChar;

    auto biggestNumber = std::to_string(error.m_EndLine + 3);
    auto currentLineChar = 0;
    for (auto lineIndex = 0; lineIndex < error.m_EndLine + 3; lineIndex++) {
        if (lineIndex == 0)
            continue;
        currentLineChar += lines[lineIndex].size() + 1;
        if (lineIndex < error.m_StartLine)
            continue;

        auto currentNumber = std::to_string(lineIndex);
        auto whitespaces = biggestNumber.size() - currentNumber.size();

        auto line = lines[lineIndex - 1];
        Utils::rtrim(line);

        out << "> " << std::string(whitespaces, ' ') << lineIndex << " | " << line << std::endl;
        if (error.m_StartLine == lineIndex - 1 && error.m_EndLine == lineIndex - 1) {
            out << "  " << std::string(biggestNumber.size(), ' ') << " | "
                << std::string(startLineDifference, ' ')
                << std::string(1, '^')
                << std::string((endLineDifference - startLineDifference) - 1, '~')
                << std::endl;
        } else if (error.m_StartLine == lineIndex - 1 && error.m_EndLine != lineIndex - 1) {
            out << "  " << std::string(biggestNumber.size(), ' ') << " | "
                << std::string(startLineDifference, ' ')
                << std::string(1, '^')
                << std::string((line.size() - startLineDifference) - 1, '~')
                << std::endl;
        } else if (error.m_StartLine != lineIndex - 1 && error.m_EndLine == lineIndex - 1) {
            auto lastSize = line.size();
            Utils::ltrim(line);
            auto difference = lastSize - line.size();
            out << "  " << std::string(biggestNumber.size(), ' ') << " | "
                << std::string(difference, ' ')
                << std::string(1, '^')
                << std::string((endLineDifference - difference) - 1, '~')
                << std::endl;
        } else if (error.m_StartLine < lineIndex - 1 && error.m_EndLine > lineIndex - 1) {
            auto lastSize = line.size();
            Utils::ltrim(line);
            auto difference = lastSize - line.size();
            out << "  " << std::string(biggestNumber.size(), ' ') << " | "
                << std::string(difference, ' ')
                << std::string(1, '^')
                << std::string(line.size() - 1, '~')
                << std::endl;
        }
    }

    return out;
}