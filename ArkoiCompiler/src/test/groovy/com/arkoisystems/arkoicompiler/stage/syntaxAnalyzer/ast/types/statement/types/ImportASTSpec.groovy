/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
 * Created ArkoiCompiler on April 25, 2020
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
package com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.types.statement.types

import com.arkoisystems.arkoicompiler.ArkoiError
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.SyntaxErrorType
import com.arkoisystems.arkoicompiler.stage.syntaxAnalyzer.ast.ArkoiASTNodeSpec

class ImportASTSpec extends ArkoiASTNodeSpec {
	
	// TODO: Fixing StringToken (getting Test instead of "Test")
	def "#1 'import' expected"() {
		given:
		def syntaxAnalyzer = this.createSyntaxAnalyzer("\"Test\"", false)
		def errors = new HashSet([
				ArkoiError.builder()
						.compilerClass(syntaxAnalyzer.getCompilerClass())
						.message(SyntaxErrorType.SYNTAX_ERROR_TEMPLATE)
						.arguments("Import", "'import'", "Test")
						.positions([
								ArkoiError.ErrorPosition.builder()
										.lineRange(ArkoiError.ErrorPosition.LineRange.make(
												syntaxAnalyzer.getCompilerClass(),
												0, 0
										))
										.charStart(1)
										.charEnd(5)
										.build()
						])
						.build()
		])
		
		expect:
		ImportAST.builder()
				.syntaxAnalyzer(syntaxAnalyzer)
				.build()
				.parseAST(null)
		syntaxAnalyzer.getErrorHandler().getCompilerErrors() == errors
	}
	
	def "#2 <string> expected"() {
		given:
		def syntaxAnalyzer = this.createSyntaxAnalyzer("import 2", false)
		def errors = new HashSet([
				ArkoiError.builder()
						.compilerClass(syntaxAnalyzer.getCompilerClass())
						.message(SyntaxErrorType.SYNTAX_ERROR_TEMPLATE)
						.arguments("Import", "<string>", "2")
						.positions([
								ArkoiError.ErrorPosition.builder()
										.lineRange(ArkoiError.ErrorPosition.LineRange.make(
												syntaxAnalyzer.getCompilerClass(),
												0, 0
										))
										.charStart(7)
										.charEnd(8)
										.build()
						])
						.build()
		])
		
		expect:
		ImportAST.builder()
				.syntaxAnalyzer(syntaxAnalyzer)
				.build()
				.parseAST(null)
		syntaxAnalyzer.getErrorHandler().getCompilerErrors() == errors
	}
	
	def "#3 <identifier> expected"() {
		given:
		def syntaxAnalyzer = this.createSyntaxAnalyzer("import \"Test\" as 2", false)
		def errors = new HashSet([
				ArkoiError.builder()
						.compilerClass(syntaxAnalyzer.getCompilerClass())
						.message(SyntaxErrorType.SYNTAX_ERROR_TEMPLATE)
						.arguments("Import", "<identifier>", "2")
						.positions([
								ArkoiError.ErrorPosition.builder()
										.lineRange(ArkoiError.ErrorPosition.LineRange.make(
												syntaxAnalyzer.getCompilerClass(),
												0, 0
										))
										.charStart(17)
										.charEnd(18)
										.build()
						])
						.build()
		])
		
		expect:
		ImportAST.builder()
				.syntaxAnalyzer(syntaxAnalyzer)
				.build()
				.parseAST(null)
		syntaxAnalyzer.getErrorHandler().getCompilerErrors() == errors
	}
	
}
