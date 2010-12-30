class InlineCoffeeScriptTests extends functionaltestplugin.FunctionalTestCase {

    void testInlineScript() {
        get '/addition'
        assertStatus 200

        form('additionForm') {
            x '2100'
            y '12'
            click 'Add'
        }
        assertElementTextContains 'result', '2100 + 12 is 2112'
    }
    
    void testJavascriptIsOnlyPulledInOnceForMultipleInlineScripts() {
        get '/multipleInlineScripts'
        assertStatus 200
        
        def numberOfJavaScriptTags = byXPath("count(//script[@type='text/javascript'])")
        assertEquals 'wrong number of javascript tags', 1, numberOfJavaScriptTags
    }
}