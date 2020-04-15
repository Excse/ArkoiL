/*
 * Copyright © 2019-2020 ArkoiSystems (https://www.arkoisystems.com/) All Rights Reserved.
<<<<<<< HEAD
 * Created ArkoiIntegration on April 05, 2020
=======
 * Created ArkoiIntegration on March 31, 2020
>>>>>>> 4201e252423986f852fc45fa32cc764656ce67be
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
package com.arkoisystems.lang.arkoi.ide.annotator

import com.arkoisystems.lang.arkoi.ArkoiFile
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class ArkoiAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if(element !is ArkoiFile)
            return
        if(element.arkoiClass == null)
            return

        element.arkoiClass?.content = element.text.toCharArray()
        element.arkoiClass?.lexicalAnalyzer?.processStage()
        element.arkoiClass?.syntaxAnalyzer?.processStage()

        val semanticAnalyzer = element.arkoiClass?.semanticAnalyzer ?: return
        if(semanticAnalyzer.processStage())
            return

        semanticAnalyzer.errorHandler.compileErrors.forEach {
            for (position in it.positions)
                holder.createErrorAnnotation(TextRange(position[0], position[1]), it.finalError)
        }
    }

}