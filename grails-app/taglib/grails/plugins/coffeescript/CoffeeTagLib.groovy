package grails.plugins.coffeescript

class CoffeeTagLib {

    static namespace = 'coffee'
    
    def inline = { attrs, body ->
        if(!pageScope.variables.alreadyIncludedCoffeeJs) {
            out << g.render(template: '/templates/coffeeScriptJs')
            pageScope.alreadyIncludedCoffeeJs = true
        }
        def code = body()
        out << g.render(template: '/templates/inlineCoffeeScript', model: [coffeeScriptCode: code])
    }
}
