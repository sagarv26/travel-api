// @SOURCE:/Users/sagar/JavaWorkspace/TravelAPI/conf/routes
// @HASH:518ce2080a954410d17a8654033b0a82a56216da
// @DATE:Sun Apr 12 15:25:14 IST 2020


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:8
private[this] lazy val controllers_DistrictController_getAllDistrict1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("district"))))
        

// @LINE:9
private[this] lazy val controllers_DistrictController_getAllDistrictsOrder2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("district/allOrder"))))
        

// @LINE:27
private[this] lazy val controllers_Assets_at3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """district""","""@controllers.DistrictController@.getAllDistrict()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """district/allOrder""","""@controllers.DistrictController@.getAllDistrictsOrder()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:8
case controllers_DistrictController_getAllDistrict1(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DistrictController]).getAllDistrict(), HandlerDef(this, "controllers.DistrictController", "getAllDistrict", Nil,"GET", """""", Routes.prefix + """district"""))
   }
}
        

// @LINE:9
case controllers_DistrictController_getAllDistrictsOrder2(params) => {
   call { 
        invokeHandler(play.api.Play.maybeApplication.map(_.global).getOrElse(play.api.DefaultGlobal).getControllerInstance(classOf[controllers.DistrictController]).getAllDistrictsOrder(), HandlerDef(this, "controllers.DistrictController", "getAllDistrictsOrder", Nil,"GET", """""", Routes.prefix + """district/allOrder"""))
   }
}
        

// @LINE:27
case controllers_Assets_at3(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     