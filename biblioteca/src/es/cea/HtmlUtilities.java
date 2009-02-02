package es.cea;

public class HtmlUtilities {
	static String head="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n<title>BIBLIOTECA</title>\n<style type=\"text/css\">\n<!--\n.style1 {\nfont-family: Verdana, Arial, Helvetica, sans-serif;\nfont-size: 12px;\ncolor: #333333;\nwidth: 640px;\nmargin-left: auto;\nmargin-right: auto;\n}\n.style2 {\nheight: 50px;\ntext-align: left;\nbackground-color: #FF3300;\nfont-size: 20px;\ncolor: #FFFFFF;\nfont-weight: bold;\npadding-left: 20px;\npadding-top: 20px;\n}\n.style3 {\nheight: 25px;\nbackground-color: #00CC33;\n}\n-->\n</style>\n</head>";
	static String cuerpo="<body>\n<div class=\"style1\" id=\"main\">\n<div class=\"style2\" id=\"titulo\">BIBLIOTECA</div>\n<hr color=\"#00CC00\"/>\n<div id=\"center\">";
	static String fin="</div>\n<hr color=\"#666666\" />\n<div class=\"style3\" id=\"foot\"></div>\n</div>\n</body>\n</html>";
	static String menuAdmin="<ul style='padding: 2px; margin-left: 0px'>"+
	"<li style='display: inline; padding: 2px 7px; margin: 3px; background-color: #FF6347'><a href='./editarlibro'>LIBROS</a></li>"+
	"<li style='display: inline; padding: 2px 7px; margin: 3px; background-color: #FF6347'><a href='./editargenero'>GENEROS</a></li>"+
	"<li style='display: inline; padding: 2px 7px; margin: 3px; background-color: #FF6347'><a href='./editarautor'>AUTORES</a></li>"+
	"<li style='display: inline; padding: 2px 7px; margin: 3px; background-color: #FF6347'><a href='./gestionusuarios'>USUARIOS</a></li>"+
	"<li style='display: inline; padding: 2px 7px; margin: 3px; background-color: #FF6347'><a href='./listaprestamos'>PRESTAMOS</a></li>"+
	"<li style='display: inline; padding: 2px 7px; margin: 3px; background-color: #FF6347'><a href='./listasolicitudes'>SOLICITUDES</a></li>"+
	"<li style='display: inline; padding: 2px 7px; margin: 3px; background-color: #FF6347'><a href='./cerrar'>CERRAR SESION</a></li>"+
	"</ul>";
	static String menuUser="<ul style='padding: 2px; margin-left: 0px'>"+
	"<li style='display: inline; padding: 2px 7px; margin: 3px; background-color: #FF6347'><a href='./biblioteca'>CATALOGO</a></li>"+
	"<li style='display: inline; padding: 2px 7px; margin: 3px; background-color: #FF6347'><a href='./consultaprestamo'>PRESTAMOS</a></li>"+
	"<li style='display: inline; padding: 2px 7px; margin: 3px; background-color: #FF6347'><a href='./registro'>SOLICITAR REGISTRO</a></li>"+
	"<li style='display: inline; padding: 2px 7px; margin: 3px; background-color: #FF6347'><a href='./login'>LOG IN</a></li>"+
	"<li style='display: inline; padding: 2px 7px; margin: 3px; background-color: #FF6347'><a href='./cerrar'>CERRAR SESION</a></li>"+
	"<li style='display: inline; padding: 2px 7px; margin: 3px; background-color: #FF6347'><a href='./loginadmin'>ADMINISTRAR</a></li>"+
	"</ul>";
	/*public HtmlUtilities(String titulo){
		this.head="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n<title>BIBLIOTECA</title>\n<style type=\"text/css\">\n<!--\n.style1 {\nfont-family: Verdana, Arial, Helvetica, sans-serif;\nfont-size: 12px;\ncolor: #333333;\nwidth: 640px;\nmargin-left: auto;\nmargin-right: auto;\n}\n.style2 {\nheight: 50px;\ntext-align: left;\nbackground-color: #FF3300;\nfont-size: 20px;\ncolor: #FFFFFF;\nfont-weight: bold;\npadding-left: 20px;\npadding-top: 20px;\n}\n.style3 {\nheight: 25px;\nbackground-color: #00CC33;\n}\n-->\n</style>\n</head>";
		this.cuerpo="<body>\n<div class=\"style1\" id=\"main\">\n<div class=\"style2\" id=\"titulo\">"+titulo+"</div>\n<hr color=\"#00CC00\"/>\n<div id=\"center\">\n<p>";
		this.fin="</p>\n</div>\n<hr color=\"#666666\" />\n<div class=\"style3\" id=\"foot\"></div>\n</div>\n</body>\n</html>";
	}*/
}
