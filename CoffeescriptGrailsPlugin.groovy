import grails.util.BuildSettingsHolder

class CoffeescriptGrailsPlugin {
    // the plugin version
    def version = "1.0-SNAPSHOT"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp",
            "grails-app/views/demo/*",
            "src/coffee/**"
    ]
    def watchedResources = "file:./src/coffee/*.coffee"

    // TODO Fill in these fields
    def author = "Jeff Brown"
    def authorEmail = ""
    def title = "CoffeeScript Plugin For Grails"
    def description = '''\\
The CoffeeScript plugin for Grails provides CoffeeScript integration.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/coffeescript"

    def onChange = { event ->
        def source = event.source
        if(source instanceof org.springframework.core.io.FileSystemResource &&
            (source.file.name.endsWith('.coffee'))) {
                // This is very much POC at this point...
            try {
                def grailsSettings = BuildSettingsHolder.settings
                def resourcesDir = grailsSettings.resourcesDir
                def coffeeCompilerLocation = System.getProperty('grails.coffeescript.compiler.location')
                if(!coffeeCompilerLocation) {
                    coffeeCompilerLocation = grailsSettings.config.grails.coffeescript.compiler.location
                    if(!coffeeCompilerLocation) {
                        coffeeCompilerLocation = 'coffee'
                    }
                }
                def proc = "${coffeeCompilerLocation} -c -o ${resourcesDir}/js/coffeescriptGenerated/ ${source.file.absolutePath}".execute()
                proc.in.eachLine { println it}
                proc.err.eachLine { System.err.println(it) }
            } catch (e) {
                System.err.println("ERROR Launching CoffeeScript compiler: ${e.message}")
            }
        }
    }
}
