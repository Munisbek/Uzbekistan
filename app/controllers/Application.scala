package controllers

import play.api._
import play.api.mvc._


object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def andijon = Action{
    Ok(views.html.andijon())
  }
  def bukhara = Action{
    Ok(views.html.bukhara())
  }
  def jizzax = Action{
    Ok(views.html.jizzax())
  }
  def qashqadaryo = Action{
    Ok(views.html.qashqadaryo())
  }
  def navoiy = Action{
    Ok(views.html.navoiy())
  }
  def namangan = Action{
    Ok(views.html.namangan())
  }
  def samarqand = Action{
    Ok(views.html.samarqand())
  }
  def surxondaryo = Action{
    Ok(views.html.surxondaryo())
  }
  def sirdaryo = Action{
    Ok(views.html.sirdaryo())
  }
  def tashkent = Action{
    Ok(views.html.tashkent())
  }
  def farghana = Action{
    Ok(views.html.farghana())
  }
  def khorezm = Action{
    Ok(views.html.khorezm())
  }
  def karakalpakistan = Action{
    Ok(views.html.karakalpakistan())
  }
  def munis = Action{
    Ok(views.html.munis())
  }
}