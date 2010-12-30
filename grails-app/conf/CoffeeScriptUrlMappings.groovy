class CoffeeScriptUrlMappings {

	static mappings = {
	    "/js/coffeescriptGenerated/$fileName" {
	        controller = 'coffeeScript'
	        action = 'generatedJavascript'
	    }
	}
}
