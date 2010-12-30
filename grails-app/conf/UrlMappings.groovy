class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
        "/addition"(view: '/demo/addition')
        "/multipleInlineScripts"(view: '/demo/multipleInlineScripts')
		"/"(view:"/index")
		"500"(view:'/error')
	}
}
