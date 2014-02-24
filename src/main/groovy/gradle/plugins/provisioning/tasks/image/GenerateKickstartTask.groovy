/*
 * Copyright 2014 Daniel Woods
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gradle.plugins.provisioning.tasks.image

import groovy.text.SimpleTemplateEngine
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class GenerateKickstartTask extends DefaultTask {

    @TaskAction
    def generate() {
        def tmpl = getClass().getResourceAsStream('/KickstartTemplate.cfg').text
        String ks = new SimpleTemplateEngine().createTemplate(tmpl).make([proj: project.provisioning])
        project.file("$project.buildDir${File.separatorChar}kickstart").mkdirs()
        project.file("$project.buildDir${File.separatorChar}kickstart${File.separatorChar}ks.cfg").write(ks)
    }
}
