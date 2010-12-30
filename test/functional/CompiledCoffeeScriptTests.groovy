class CompiledCoffeeScriptTests extends functionaltestplugin.FunctionalTestCase {

    void testCompiledScript() {
        get '/multiplication'
        assertStatus 200

        form('multiplicationForm') {
            x '3'
            y '14'
            click 'Multiply'
        }
        assertElementTextContains 'result', '3 * 14 is 42'
    }
}