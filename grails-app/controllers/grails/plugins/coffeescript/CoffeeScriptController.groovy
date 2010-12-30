package grails.plugins.coffeescript

class CoffeeScriptController {

    def generatedJavascript = {
        def fileName = params.fileName
        def pathToResource = "/js/coffeescriptGenerated/${fileName}.js"
        def istream = CoffeeScriptController.getResourceAsStream(pathToResource)
        if(istream) {
            response.contentType = 'text/javascript'
            response.outputStream << istream
        } else {
            log.warn "File '${pathToResource}' does not exist"
            response.sendError(404)
        }
    }
}