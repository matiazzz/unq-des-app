"use strict";angular.module("desappGrouphFrontendApp",["ngAnimate","ngAria","ngCookies","ngMessages","ngResource","ngRoute","ngSanitize","ngTouch","pascalprecht.translate","ui.bootstrap","auth0.lock","angular-jwt"]).config(["$routeProvider",function(a){a.when("/",{templateUrl:"views/main.html",controller:"MainCtrl",controllerAs:"main"}).when("/about",{templateUrl:"views/about.html",controller:"AboutCtrl",controllerAs:"about"}).when("/events",{templateUrl:"views/events.html",controller:"EventService",controllerAs:"events"}).when("/search-events",{templateUrl:"views/search-events.html",controller:"SearchEventCtrl",controllerAs:"search-events"}).otherwise({redirectTo:"/"})}]).config(["$translateProvider",function(a){a.translations("en",{APPNAME:"Where we go?",HOME:"Home",EVENTS:"Events",SEARCH:"Search",login:"Login"}),a.translations("es",{APPNAME:"¿A dónde vamos?",HOME:"Inicio",EVENTS:"Eventos",SEARCH:"Buscar",login:"Entrar"}),a.preferredLanguage("es")}]).config(["lockProvider",function(a){a.init({clientID:"HpQcbV9OE6ImZNpqW8LDhBlppJnOaWRM",domain:"matiazzz.auth0.com"})}]),angular.module("desappGrouphFrontendApp").controller("MainCtrl",function(){this.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"]}),angular.module("desappGrouphFrontendApp").controller("AboutCtrl",function(){this.awesomeThings=["HTML5 Boilerplate","AngularJS","Karma"]});var url="https://unq-des-app.herokuapp.com/rest/";angular.module("desappGrouphFrontendApp").controller("UserService",["$scope","$http",function(a,b){b.get(url+"user/getAll").then(function(b){a.allUsers=b.data})}]),angular.module("desappGrouphFrontendApp").controller("EventService",["$scope","$http",function(a,b){b.get(url+"event/mostPopular").then(function(b){a.mostPopularEvents=b.data}),b.get(url+"event/getAll").then(function(b){a.events=b.data}),b.get(url+"event/size").then(function(b){a.events=b.data})}]),angular.module("desappGrouphFrontendApp").service("eventServices",["$http",function(a){return{getAll:function(){return a({method:"get",url:url+"event/getAll"})},get:function(b){return a({method:"get",url:url+"event/"+b})},getSize:function(){return a({method:"get",url:url+"event/size"})},getPage:function(b,c){return a({method:"get",url:url+"event/get/"+b+"/"+c})}}}]),angular.module("desappGrouphFrontendApp").controller("EventsCtrl",function(){}),angular.module("desappGrouphFrontendApp").controller("SearchEventCtrl",["$scope","$uibModal","eventServices",function(a,b,c){c.getSize().then(function(b){a.eventsSize=b.data.size,a.eventsSize/9>0?a.pages=parseInt(a.eventsSize/9+1):a.pages=parseInt(a.eventsSize/9)},function(a){console.log(a)}),a.loadPage=function(b){console.log(b,a.eventsSize),c.getPage(b,9).then(function(b){a.events=b.data},function(a){console.log(a)})},a.showEventDetail=function(a){b.open({templateUrl:"views/event-detail.html",controller:"eventDetailCtrl",size:"lg",resolve:{idEvent:function(){return a}}})},a.getPages=function(a){return new Array(a)},a.loadPage(1)}]),angular.module("desappGrouphFrontendApp").controller("eventDetailCtrl",["$scope","$uibModalInstance","eventServices","idEvent",function(a,b,c,d){c.get(d).then(function(b){a.event=b.data},function(a){console.log(a)}),a.close=function(){b.dismiss("cancel")}}]),function(){function a(a){var b=this;b.authService=a}angular.module("desappGrouphFrontendApp").controller("LoginCtrl",a),a.$inject=["authService"]}(),function(){function a(a,b){function c(){a.show()}function d(){localStorage.removeItem("id_token"),b.unauthenticate()}function e(){a.on("authenticated",function(a){localStorage.setItem("id_token",a.idToken),b.authenticate()})}return{login:c,logout:d,registerAuthenticationListener:e}}angular.module("desappGrouphFrontendApp").service("authService",a),a.$inject=["lock","authManager"]}(),angular.module("desappGrouphFrontendApp").run(["$templateCache",function(a){a.put("views/about.html","<p>This is the about view.</p>"),a.put("views/event-detail.html",'<div class="modal-header"> <h3 class="modal-title" id="modal-title">{{event.title}}</h3> </div> <div class="modal-body" id="modal-body"> <img class="img-detail" ng-src="{{event.urlImg}}" alt="..."> </div> <div class="modal-body" id="modal-body"> <p>{{event.description}}</p> </div> <div class="modal-footer"> <button class="btn btn-danger" type="button" ng-click="close()">Cerrar</button> </div>'),a.put("views/events.html",'<div class="container"> <div id="carousel-example-generic" class="carousel slide" data-ride="carousel"> <!-- Indicators --> <ol class="carousel-indicators"> <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li> <li data-target="#carousel-example-generic" data-slide-to="1"></li> <li data-target="#carousel-example-generic" data-slide-to="2"></li> </ol> <!-- Wrapper for slides --> <div class="carousel-inner"> <div class="item" ng-class="{\'item active\': $first}" ng-repeat="event in mostPopularEvents"> <img ng-src="{{event.urlImg}}" alt="..."> <div class="carousel-caption"> <h2>{{event.title}}</h2> </div> </div> </div> <!-- Controls --> <!--<a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">\n      <span class="glyphicon glyphicon-chevron-left"></span>\n    </a>\n    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">\n      <span class="glyphicon glyphicon-chevron-right"></span>\n    </a>--> </div> </div> <div class="container"> <div class="row"> <h2 class="margin-label"><span class="label label-default col-sm-12 margin-label">Música</span></h2> <div class="col-sm-12 col-md-4" ng-repeat="event in mostPopularEvents"> <div class="thumbnail eventPreview"> <img class="img-event" ng-src="{{event.urlImg}}" alt="..."> <div class="caption"> <h4>{{event.title}}</h4> <p><a class="btn btn-primary" role="button">Más info</a> <a class="btn btn-default" role="button">Asistiré</a></p> </div> </div> </div> </div> <div class="row"> <h2 class="margin-label"><span class="label label-default col-sm-12 margin-label">Cine</span></h2> <div class="col-sm-12 col-md-4" ng-repeat="event in mostPopularEvents"> <div class="thumbnail eventPreview"> <img class="img-event" ng-src="{{event.urlImg}}" alt="..."> <div class="caption"> <h4>{{event.title}}</h4> <p><a class="btn btn-primary" role="button">Más info</a> <a class="btn btn-default" role="button">Asistiré</a></p> </div> </div> </div> </div> <div class="row"> <h2 class="margin-label"><span class="label label-default col-sm-12 margin-label">Gastronomía</span></h2> <div class="col-sm-12 col-md-4" ng-repeat="event in mostPopularEvents"> <div class="thumbnail eventPreview"> <img class="img-event" ng-src="{{event.urlImg}}" alt="..."> <div class="caption"> <h4>{{event.title}}</h4> <p><a class="btn btn-primary" role="button">Más info</a> <a class="btn btn-default" role="button">Asistiré</a></p> </div> </div> </div> </div> <h2><a href="#/search-events"><span class="col-sm-12 label label-info margin-label">Ver todos los eventos</span></a></h2> </div>'),a.put("views/main.html",'<div class="jumbotron"> <h1>{{\'APPNAME\' | translate}}</h1> <p class="lead"> <img src="images/yeoman.8cb970fb.png" alt="I\'m Yeoman"><br> Always a pleasure scaffolding your apps. </p> <p><a class="btn btn-lg btn-success" ng-href="#/">Splendid!<span class="glyphicon glyphicon-ok"></span></a></p> </div> <div class="container"> <div class="container"> <div class="row"> <div class="col-sm-4"> <div class="row"> <div class="col-sm-10 col-sm-offset-2 text-center"><h3>{{\'EVENTS\' | translate}}</h3><p>Enterate de todos los eventos disponibles y compartelos con tus amigos.</p></div> </div> </div> <div class="col-sm-4 text-center"> <div class="row"> <div class="col-sm-10 col-sm-offset-1 text-center"><h3>Salidas</h3><p>Organiza salidas para ir con tus amigos, pareja o incluso salidas para ir solo.</p></div> </div> </div> <div class="col-sm-4 text-center"> <div class="row"> <div class="col-sm-10 text-center"><h3>Perfil</h3><p>Creá tu perfil con todos tus gustos y amigos asi podemos recomendarte los mejores eventos para vos.</p></div> </div> </div> </div><!--/row--> <div class="row"><br></div> </div><!--/container--> </div>'),a.put("views/search-events.html",'<div class="container"> <div class="row"> <div class="custom-search-input"> <div class="input-group col-md-12"> <input type="text" class="search-query form-control" placeholder="{{\'SEARCH\' | translate}}"> <span class="input-group-btn"> <button class="btn btn-default" type="button"> <span class="glyphicon glyphicon-search"></span> </button> </span> </div> </div> </div> </div> <div class="container"> <div class="row"> <div class="col-sm-12 col-md-4" ng-repeat="event in events"> <div class="thumbnail eventPreview"> <img class="img-event" ng-src="{{event.urlImg}}" alt="..."> <div class="caption"> <h4>{{event.title}}</h4> <p><a ng-click="showEventDetail(event.id)" class="btn btn-primary" role="button">Más info</a> <a class="btn btn-default" role="button">Asistiré</a></p> </div> </div> </div> </div> </div> <div class="pagination-centered"> <nav aria-label="Page navigation"> <ul class="pagination"> <li> <a href aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a> </li> <li ng-repeat="i in getPages(pages) track by $index"> <a href ng-click="loadPage($index+1)">{{$index+1}}</a> </li> <li> <a href aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a> </li> </ul> </nav> </div>')}]);