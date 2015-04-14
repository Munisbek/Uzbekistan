//package controllers
//
//import play.api.mvc._
//import play.api.db.slick.Config.driver.simple._
//import play.api.db.slick._
//import models._
//import play.api.Logger
//
//import scala.slick.lifted.TableQuery
//
//
//class Comments extends Controller {
//  val commit = TableQuery[CommitTable]
//
//
//
//  def commitsList = DBAction { implicit rs =>
//    Logger.info(s"SHOW_ALL = ${commit.list}")
//    Ok(views.html.commitsList(commit.list))
//  }
//
//  def showAddForm = Action {
//    Ok(views.html.commits())
//  }
//
//
//  def add = DBAction { implicit request =>
//    val formParams = request.body.asFormUrlEncoded
//    val name = formParams.get("NAME")(0)
//    val comments = formParams.get("COMMENTS")(0)
//
//    val CommitId = (commit returning commit.map(_.id)) += Commit(None, name, comments)
//     Logger.info(s"LastId = $CommitId")
//    Redirect(routes.Comments.list())
//  }
//
//  def remove(id: Int) = DBAction { implicit request =>
//    commit.filter(_.id === id). delete;
//    Redirect(routes.Comments.list())
//  }
//}
