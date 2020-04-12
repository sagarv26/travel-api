// @SOURCE:/Users/sagar/JavaWorkspace/TravelAPI/conf/routes
// @HASH:518ce2080a954410d17a8654033b0a82a56216da
// @DATE:Sun Apr 12 15:25:14 IST 2020

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:27
// @LINE:9
// @LINE:8
// @LINE:6
package controllers {

// @LINE:27
class ReverseAssets {
    

// @LINE:27
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:9
// @LINE:8
class ReverseDistrictController {
    

// @LINE:9
def getAllDistrictsOrder(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "district/allOrder")
}
                                                

// @LINE:8
def getAllDistrict(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "district")
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:27
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:27
class ReverseAssets {
    

// @LINE:27
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:9
// @LINE:8
class ReverseDistrictController {
    

// @LINE:9
def getAllDistrictsOrder : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DistrictController.getAllDistrictsOrder",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "district/allOrder"})
      }
   """
)
                        

// @LINE:8
def getAllDistrict : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.DistrictController.getAllDistrict",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "district"})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:27
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.ref {


// @LINE:27
class ReverseAssets {
    

// @LINE:27
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:9
// @LINE:8
class ReverseDistrictController {
    

// @LINE:9
def getAllDistrictsOrder(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DistrictController]).getAllDistrictsOrder(), HandlerDef(this, "controllers.DistrictController", "getAllDistrictsOrder", Seq(), "GET", """""", _prefix + """district/allOrder""")
)
                      

// @LINE:8
def getAllDistrict(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DistrictController]).getAllDistrict(), HandlerDef(this, "controllers.DistrictController", "getAllDistrict", Seq(), "GET", """""", _prefix + """district""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    