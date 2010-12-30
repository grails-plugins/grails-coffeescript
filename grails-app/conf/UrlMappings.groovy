class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		"/multiplication"(view: '/demo/multiplication')
        "/addition"(view: '/demo/addition')
        "/multipleInlineScripts"(view: '/demo/multipleInlineScripts')
		"/"(view:"/index")
		"500"(view:'/error')
	}
}
