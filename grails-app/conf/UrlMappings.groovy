class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
        "/addition"(view: '/math/addition')
        "/multipleInlineScripts"(view: '/multipleInlineScripts')
		"/"(view:"/index")
		"500"(view:'/error')
	}
}
