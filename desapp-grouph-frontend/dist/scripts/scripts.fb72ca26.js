"use strict";angular.module("desappGrouphFrontendApp",["ngAnimate","ngAria","ngCookies","ngMessages","ngResource","ngRoute","ngSanitize","ngTouch","pascalprecht.translate","ui.bootstrap","auth0.lock","angular-jwt","ngMaterial","ngMessages","ngMap","tmh.dynamicLocale"]).config(["$routeProvider",function(a){a.when("/",{templateUrl:"views/events.html",controller:"EventsMainCtrl",controllerAs:"eventsMain"}).when("/search-events",{templateUrl:"views/search-events.html",controller:"SearchEventCtrl",controllerAs:"search-events"}).when("/proposals",{templateUrl:"views/proposals.html",controller:"ProposalsCtrl"}).when("/select-event-type",{templateUrl:"views/select-event-type.html",controller:"CreateEventCtrl"}).when("/create-event",{templateUrl:"views/create-event.html",controller:"CreateEventCtrl"}).when("/login",{templateUrl:"views/login.html",controller:"LoginCtrl",controllerAs:"loginCtrl"}).when("/profile/:username",{templateUrl:"views/profile.html",controller:"ProfileCtrl",controllerAs:"profileCtrl"}).when("/create-user",{templateUrl:"views/create-user.html",controller:"CreateUserCtrl",controllerAs:"createUserCtrl"}).when("/pagenotfound",{templateUrl:"404.html"}).otherwise({redirectTo:"/"})}]).config(["$translateProvider","tmhDynamicLocaleProvider",function(a,b){a.translations("en",{APPNAME:"Where we go?",HOME:"Home",EVENTS:"Events",PROPOSAL:"Proposals",FREE:"Free",WITHFRIENDS:"With friends",TODAY:"Today",WITHCOUPLE:"With couple",SUPRISEDME:"Suprised me",SEARCH:"Search",login:"Login",logout:"Logout",description:"Description",price:"Price",plannings:"Plannings",preferences:"Preferences",profile:"Profile",settings:"Setting",myevents:"My events",newevent:"New event",language:"Language",spanish:"Spanish",english:"English"}),a.translations("es",{APPNAME:"¿A dónde vamos?",HOME:"Inicio",EVENTS:"Eventos",PROPOSAL:"Propuestas",FREE:"Gratis",WITHFRIENDS:"Con amigos",TODAY:"Hoy",WITHCOUPLE:"En pareja",SUPRISEDME:"Sorprendeme",SEARCH:"Buscar",login:"Iniciar sesión",logout:"Salir",description:"Descripción",price:"Precio",plannings:"Salidas",preferences:"Preferencias",profile:"Perfil",settings:"Configuración",myevents:"Mis eventos",newevent:"Nuevo evento",language:"Idioma",spanish:"Español",english:"Inglés"}),a.preferredLanguage("es"),b.localeLocationPattern("/scripts/angular-i18n/angular-locale_{{locale}}.js")}]).config(["lockProvider","jwtOptionsProvider",function(a,b){a.init({clientID:"HpQcbV9OE6ImZNpqW8LDhBlppJnOaWRM",domain:"matiazzz.auth0.com"}),b.config({tokenGetter:function(){return localStorage.getItem("id_token")}})}]);var url="https://unq-des-app.herokuapp.com/rest/";angular.module("desappGrouphFrontendApp").service("eventServices",["$http",function(a){return{getAll:function(){return a({method:"get",url:url+"event/getAll"})},get:function(b){return a({method:"get",url:url+"event/"+b})},getFreeEvents:function(){return a({method:"get",url:url+"event/getFreeEvents"})},getWithFriendsEvents:function(){return a({method:"get",url:url+"event/getWithFriendsEvents"})},getTodayEvents:function(){return a({method:"get",url:url+"event/getTodayEvents"})},getWithCoupleEvents:function(){return a({method:"get",url:url+"event/getWithCoupleEvents"})},getSuprisedMeEvents:function(){return a({method:"get",url:url+"event/getSuprisedMeEvents"})},getMostPopulars:function(b){return a({method:"get",url:url+"event/mostPopular"})},getSize:function(){return a({method:"get",url:url+"event/size"})},getPage:function(b,c){return a({method:"get",url:url+"event/get/"+b+"/"+c})},searchSize:function(b){return a({method:"get",url:url+"event/searchSize/"+b})},search:function(b,c,d){return a({method:"get",url:url+"event/search/"+b+"/"+c+"/"+d})},newEvent:function(b,c,d,e,f,g,h,i){return a({method:"post",url:url+"event/newEvent/",data:$.param({username:b,title:c,description:d,imgUrl:e,day:f.getUTCDate(),month:f.getMonth()+1,year:f.getFullYear(),hour:g.getHours(),minutes:g.getMinutes(),price:h,placeName:i.name,placeAddress:i.address}),headers:{"Content-Type":"application/x-www-form-urlencoded"}})},attend:function(b,c){return a({method:"post",url:url+"event/attend",data:$.param({username:b,idEvent:c}),headers:{"Content-Type":"application/x-www-form-urlencoded"}})}}}]),angular.module("desappGrouphFrontendApp").service("userServices",["$http",function(a){return{getAll:function(){return a({method:"get",url:url+"user/getAll"})},getById:function(b){return a({method:"get",url:url+"user/"+b})},getByUsername:function(b){return a({method:"get",url:url+"user/getByUsername/"+b})},exists:function(b){return a({method:"get",url:url+"user/exists/"+b})}}}]),angular.module("desappGrouphFrontendApp").controller("EventsMainCtrl",["$scope","eventServices",function(a,b){b.getMostPopulars().then(function(b){a.mostPopularEvents=b.data},function(a){console.log(a)})}]),angular.module("desappGrouphFrontendApp").controller("SearchEventCtrl",["$scope","eventServices",function(a,b){function c(a,b){return a/b>0?parseInt(a/b+1):parseInt(a/b)}a.eventsPerPage=9,a.showMsg=!1,a.searching=!1,a.word="",b.getSize().then(function(b){a.pages=c(b.data.size,a.eventsPerPage)},function(a){console.log(a)}),a.enableSearch=function(){return""!=a.word},a.loadPage=function(c){b.getPage(c,a.eventsPerPage).then(function(b){a.events=b.data,a.actualPage=c,a.searching=!1},function(a){console.log(a)})},a.searchEvents=function(d){b.searchSize(a.word).then(function(b){a.pagesForSearch=c(b.data.size,a.eventsPerPage)},function(a){console.log(a)}),b.search(a.word,d,a.eventsPerPage).then(function(b){a.events=b.data,a.actualPage=d,a.searching=!0,a.showMsg=!1},function(b){a.showMsg=!0})},a.activePage=function(b){return a.actualPage===b},a.getPages=function(a){return new Array(a)},a.loadPage(1)}]),angular.module("desappGrouphFrontendApp").controller("EventDetailCtrl",["$scope","$uibModalInstance","eventServices","idEvent","loggedUser",function(a,b,c,d,e){function f(b){c.get(b).then(function(b){a.event=b.data,a.eventDate=new Date(a.event.date[0],a.event.date[1]-1,a.event.date[2],a.event.time.hourOfDay,a.event.time.minuteOfHour),a.attendees=a.event.attendees.length},function(a){console.log(a)})}a.attend=function(){c.attend(e.getUsername(),a.event.id).then(function(b){a.attendees=a.attendees+1,f(d)},function(a){console.log(a)})},f(d),a.close=function(){b.dismiss("cancel")}}]),angular.module("desappGrouphFrontendApp").service("authService",["lock","authManager","$q",function(a,b,c){function d(){return i.promise}function e(){a.show()}function f(){localStorage.removeItem("id_token"),b.unauthenticate()}function g(){a.on("authenticated",function(c){a.getProfile(c.idToken,function(a,d){return a?console.log(a):(localStorage.setItem("profile",JSON.stringify(d)),i.resolve(d),localStorage.setItem("id_token",c.idToken),void b.authenticate())})})}var h=JSON.parse(localStorage.getItem("profile"))||null,i=c.defer();return h&&i.resolve(h),{login:e,logout:f,registerAuthenticationListener:g,getProfileDeferred:d}}]),angular.module("desappGrouphFrontendApp").controller("LoginCtrl",["$scope","$rootScope","authService","loggedUser",function(a,b,c,d){a.authService=c,a.existsUser=!1,c.getProfileDeferred().then(function(b){a.profile=b,d.setUsername(b.nickname)})}]),angular.module("desappGrouphFrontendApp").factory("loggedUser",function(){return this.setUsername=function(a){this.username=a},this.getUsername=function(){return this.username},{getUsername:this.getUsername,setUsername:this.setUsername}}),angular.module("desappGrouphFrontendApp").controller("CreateEventCtrl",["$scope","$location","eventServices","loggedUser",function(a,b,c,d){a.alerts={success:[],errors:[]},a.event={title:"",description:"",imgUrl:"",price:0,place:{name:"",address:""}},a.selectEventType=function(a){b.path("/create-event")},a.createEvent=function(){c.newEvent(d.getUsername(),a.event.title,a.event.description,a.event.imgUrl,a.dt,a.mytime,a.event.price,a.event.place).then(function(b){a.alerts.success=[1]},function(a){console.log(a)})},a.today=function(){a.dt=new Date},a.today(),a.clear=function(){a.dt=null},a.options={minDate:new Date,showWeeks:!0},a.toggleMin=function(){a.options.minDate=a.options.minDate?null:new Date},a.toggleMin(),a.setDate=function(b){a.dt=b},a.mytime=new Date,a.ismeridian=!1,a.hstep=1,a.mstep=1,a.setTime=function(b){a.mytime=b},a.update=function(){var b=new Date;b.setHours(14),b.setMinutes(0),a.mytime=b}}]),angular.module("desappGrouphFrontendApp").controller("HeaderCtrl",["$scope","$location","$translate","tmhDynamicLocale",function(a,b,c,d){a.isActive=function(a){return a===b.path()},a.changeLanguage=function(a){c.use(a),"es"===a?d.set(a+"-ar"):d.set(a+"-us")}}]),angular.module("desappGrouphFrontendApp").controller("ProfileCtrl",["$scope","$location","userServices","$routeParams",function(a,b,c,d){c.getByUsername(d.username).then(function(b){a.user=b.data,a.hasEvents=a.user.myEvents.events.length>0},function(a){b.path("/404.html")})}]),angular.module("desappGrouphFrontendApp").factory("User",function(){return{username:""}}),angular.module("desappGrouphFrontendApp").controller("CreateUserCtrl",function(){}),angular.module("desappGrouphFrontendApp").controller("ShowEventDetailCtrl",["$scope","$uibModal",function(a,b){a.showEventDetail=function(a){b.open({templateUrl:"views/event-detail.html",controller:"EventDetailCtrl",size:"lg",resolve:{idEvent:function(){return a}}})},a.close=function(){$uibModalInstance.dismiss("cancel")}}]),angular.module("desappGrouphFrontendApp").controller("ProposalsCtrl",["$scope","$http","loggedUser",function(a,b,c){b.get("https://unq-des-app.herokuapp.com/rest/event/getAll").then(function(b){a.events=b.data}),a.filterGetFreeEvents=function(){b.get("https://unq-des-app.herokuapp.com/rest/event/getFreeEvents").then(function(b){a.events=b.data})},a.filterGetWithFriendsEvents=function(){b.get("https://unq-des-app.herokuapp.com/rest/event/getWithFriendsEvents/"+c.getUsername()).then(function(b){a.events=b.data})},a.filterGetTodayEvents=function(){b.get("https://unq-des-app.herokuapp.com/rest/event/getTodayEvents").then(function(b){a.events=b.data})},a.filterGetWithCoupleEvents=function(){b.get("https://unq-des-app.herokuapp.com/rest/event/getWithCoupleEvents/"+c.getUsername()).then(function(b){a.events=b.data})},a.filterGetSuprisedMeEvents=function(){b.get("https://unq-des-app.herokuapp.com/rest/event/getSurprisedMeEvents/"+c.getUsername()).then(function(b){a.events=b.data})}}]),angular.module("desappGrouphFrontendApp").run(["$rootScope","authService","lock","tmhDynamicLocale","authManager",function(a,b,c,d,e){a.authService=b,b.registerAuthenticationListener(),c.interceptHash(),e.checkAuthOnRefresh(),d.set("es-ar")}]),angular.module("desappGrouphFrontendApp").run(["$templateCache",function(a){a.put("views/create-event.html",'<div class="messagealert" ng-repeat="alert in alerts.success"> <div class="alert alert-success alert-dismissible superposition"> <a href class="close" data-dismiss="alert" aria-label="close">&times;</a> <div class="text-center"> <strong>Se creó un nuevo evento.</strong>. </div> </div> </div> <div class="messagealert" ng-repeat="alert in alerts.errors"> <div class="alert alert-danger alert-dismissible superposition"> <a href class="close" data-dismiss="alert" aria-label="close">&times;</a> <div class="text-center"> <strong>Ocurrió un error al intentar crear el evento.</strong>. </div> </div> </div> <form ng-if="isAuthenticated"> <h3 class="text-center"> Crear evento </h3> <div class="form-group"> <label>Nombre del evento</label> <input class="form-control" ng-model="event.title" placeholder="Nombre del evento" required> </div> <hr> <div class="form-group"> <label for="exampleTextarea">Descripción</label> <textarea class="form-control" rows="3" ng-model="event.description" placeholder="Escriba una descripción del evento." required></textarea> </div> <hr> <div class="form-group"> <label>Lugar del evento</label> <input class="form-control" ng-model="event.place.name" placeholder="Nombre del lugar" required> <input class="form-control" ng-model="event.place.address" placeholder="Dirección del lugar" required> </div> <hr> <div class="form-group"> <label for="exampleInputFile">Imágen</label> <input class="form-control" ng-model="event.imgUrl" placeholder="Url de una imágen (opcional)"> </div> <hr> <div class="row"> <div class="col-md-6"> <div style="display:inline-block; min-height:290px"> <label>Fecha del evento</label> <div uib-datepicker ng-model="dt" class="well well-sm" ng-change="setDate(dt)" datepicker-options="options"></div> </div> </div> <div class="col-md-6"> <label>Horario del evento</label> <div uib-timepicker ng-model="mytime" hour-step="hstep" minute-step="mstep" ng-change="setTime(mytime)" show-meridian="ismeridian"></div> </div> <pre class="alert alert-info"><em>{{dt | date:\'fullDate\' }}</em></pre> <pre class="alert alert-info">{{mytime | date:\'shortTime\' }}</pre> </div> <hr> <div class="form-group"> <label>Precio del evento</label> <input class="form-control" ng-model="event.price" placeholder="Precio del evento" required> </div> <hr> <button type="submit" class="btn btn-primary" ng-click="createEvent()">Crear evento</button> </form> <br>'),a.put("views/create-user.html","<p>Crear usuario nuevo.</p>"),a.put("views/event-detail.html",'<div class="modal-header"> <h3 class="modal-title" id="modal-title">{{event.title}} <span ng-click="close()" class="glyphicon glyphicon-remove pull-right"></span> </h3> </div> <div class="modal-body" id="modal-body"> <img class="img-detail" ng-src="{{event.urlImg}}" alt="..."> </div> <div class="modal-body" ng-if="isAuthenticated"> <div> <button type="button" class="btn btn-default pull-right" ng-click="attend()">Asistiré</button> </div> </div> <hr> <div class="modal-body" id="modal-body"> <md-content> <md-tabs md-dynamic-height="" md-border-bottom=""> <md-tab label="{{\'description\' | translate}}"> <md-content class="md-padding"> <div ng-bind-html="event.description"></div> </md-content> </md-tab> <md-tab label="{{\'price\' | translate}}"> <md-content class="md-padding"> <h3> {{ event.price | currency }} </h3> </md-content> </md-tab> <md-tab label="Día y horario"> <md-content class="md-padding"> <h3> {{eventDate | date:\'fullDate\'}} </h3> <h3> {{eventDate | date:\'shortTime\'}} </h3> </md-content> </md-tab> <md-tab label="Ubicación"> <md-content class="md-padding"> <h3> {{event.place.name}} </h3> <h4> {{event.place.address}} </h4> <map center="{{event.place.address}}"> </md-content> </md-tab> <md-tab label="{{attendees}} asistires"> <md-content class="md-padding"> <div class="container" style="margin-top:20px"> <div class="row"> <div class="col-sm-12 col-md-4" ng-repeat="user in event.attendees"> <div class="media"> <a href="#/profile/{{user.userName}}" ng-click="close()" class="pull-left"> <img alt="64x64" data-src="holder.js/64x64" class="media-object img-thumbnail" style="width: 64px; height: 64px" src="http://placehold.it/64x64"> </a> <div class="media-body"> <h4 class="media-heading"><a ng-click="close()" href="#/profile/{{user.userName}}">{{user.userName}}</a></h4> </div> </div> </div> </div> </div> </md-content> </md-tab> </md-tabs> </md-content> </div> <div class="modal-footer"> </div>'),a.put("views/events.html",'<div class="container"> <div id="events-carousel" class="carousel slide" data-ride="carousel"> <!-- Indicators --> <ol class="carousel-indicators"> <li data-target="#events-carousel" data-slide-to="0" class="active"></li> <li data-target="#events-carousel" data-slide-to="1"></li> <li data-target="#events-carousel" data-slide-to="2"></li> </ol> <!-- Wrapper for slides --> <div class="carousel-inner"> <div class="item" ng-class="{\'item active\': $first}" ng-repeat="event in mostPopularEvents"> <img ng-src="{{event.urlImg}}" alt="..."> <div class="carousel-caption"> <h2>{{event.title}}</h2> </div> </div> </div> <!-- Controls --> <a class="left carousel-control pointer" data-target="#events-carousel" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"></span> </a> <a class="right carousel-control pointer" data-target="#events-carousel" data-slide="next"> <span class="glyphicon glyphicon-chevron-right"></span> </a> </div> </div> <div class="container"> <div class="row"> <h2 class="margin-label"><span class="label label-default col-sm-12 margin-label">Música</span></h2> <div class="col-sm-12 col-md-4" ng-repeat="event in mostPopularEvents"> <div class="thumbnail eventPreview"> <img ng-controller="ShowEventDetailCtrl" ng-click="showEventDetail(event.id)" class="img-event" ng-src="{{event.urlImg}}" alt="..."> <div class="caption"> <h4 ng-controller="ShowEventDetailCtrl" ng-click="showEventDetail(event.id)">{{event.title}}</h4> </div> </div> </div> </div> <div class="row"> <h2 class="margin-label"><span class="label label-default col-sm-12 margin-label">Cine</span></h2> <div class="col-sm-12 col-md-4" ng-repeat="event in mostPopularEvents"> <div class="thumbnail eventPreview"> <img ng-controller="ShowEventDetailCtrl" ng-click="showEventDetail(event.id)" class="img-event" ng-src="{{event.urlImg}}" alt="..."> <div class="caption"> <h4 ng-controller="ShowEventDetailCtrl" ng-click="showEventDetail(event.id)">{{event.title}}</h4> </div> </div> </div> </div> <div class="row"> <h2 class="margin-label"><span class="label label-default col-sm-12 margin-label">Gastronomía</span></h2> <div class="col-sm-12 col-md-4" ng-repeat="event in mostPopularEvents"> <div class="thumbnail eventPreview"> <img ng-controller="ShowEventDetailCtrl" ng-click="showEventDetail(event.id)" class="img-event" ng-src="{{event.urlImg}}" alt="..."> <div class="caption"> <h4 ng-controller="ShowEventDetailCtrl" ng-click="showEventDetail(event.id)">{{event.title}}</h4> </div> </div> </div> </div> <h2><a href="#/search-events"><span class="col-sm-12 label label-info margin-label">Ver todos los eventos</span></a></h2> </div>'),a.put("views/login.html",'<h4 ng-click="authService.login()" translate="login"></h4>'),a.put("views/profile.html",'<div class="container"> <div class="row clearfix well"> <div class="col-md-2 column"> <img class="img-thumbnail" alt="140x140" src="http://lorempixel.com/140/140/"> </div> <div class="col-md-8 column"> <blockquote> <p> {{user.name}} {{user.lastName}} </p> <small>{{user.userName}}</small> </blockquote> </div> <div class="col-md-2 column"> </div> </div> <div class="row clearfix"> <div class="col-md-12 column"> <div class="tabbable" id="tabs-444468"> <ul class="nav nav-tabs"> <li class="active"> <a class="pointer" data-target="#about-tab" data-toggle="tab">Sobre mi</a> </li> <li> <a class="pointer" data-target="#events-tab" data-toggle="tab">Eventos</a> </li> </ul> <div class="tab-content"> <div class="tab-pane active" id="about-tab"> <div class="row clearfix"> <div class="col-md-6 column"> <table class="table"> <thead> <tr> <th> Sobre mi </th> <th> </th> </tr> </thead> <tbody> <tr> <td> Nombre </td> <td>{{user.name}} {{user.lastName}}</td> </tr> <tr> <td> Username </td> <td>{{user.userName}}</td> </tr> </tbody> </table> </div> <div class="col-md-6 column"> <table class="table"> <thead> <tr> <th> Mis gustos </th> <th> </th> </tr> </thead> <tbody> </tbody> </table> <h4 class="text-center">Música <div class="row"> <div ng-repeat="tag in user.profile.musicalGenres" class="col-md-2"> <h5><span class="label label-default myLabel">{{tag}}</span></h5> </div> </div> <hr> <h4 class="text-center">Cine <div class="row"> <div ng-repeat="tag in user.profile.movieGenres" class="col-md-2"> <h5><span class="label label-default myLabel">{{tag}}</span></h5> </div> </div> <hr> <h4 class="text-center">Comida <div class="row"> <div ng-repeat="tag in user.profile.musicalGenres" class="col-md-2"> <h5><span class="label label-default myLabel">{{tag}}</span></h5> </div> </div> </h4></h4></h4></div> </div> </div> <div class="tab-pane" id="events-tab"> <div class="col-md-12 column"> <h3 class="margin-label"><span class="label label-default col-sm-12 margin-label">Mis eventos</span></h3> <div ng-if="! hasEvents"> <h4 class="text-center">No tienes eventos. </h4> </div> <div class="row"> <div class="col-sm-12 col-md-4" ng-repeat="event in user.myEvents.events"> <div class="thumbnail eventPreview"> <img ng-controller="ShowEventDetailCtrl" ng-click="showEventDetail(event.id)" class="img-event-min" ng-src="{{event.urlImg}}" alt="..."> <div class="caption"> <h4 ng-controller="ShowEventDetailCtrl" ng-click="showEventDetail(event.id)">{{event.title}}</h4> </div> </div> </div> </div> </div> </div> </div> </div> </div> </div> </div>'),a.put("views/proposals.html",'<div class="btn-group btn-group-justified" role="group" aria-label="..."> <div class="btn-group" role="group"> <button type="button" class="btn btn-default" ng-click="filterGetFreeEvents()" translate="FREE"></button> </div> <div class="btn-group" role="group"> <button type="button" class="btn btn-default" ng-click="filterGetWithFriendsEvents()" translate="WITHFRIENDS"></button> </div> <div class="btn-group" role="group"> <button type="button" class="btn btn-default" ng-click="filterGetTodayEvents()" translate="TODAY"></button> </div> <div class="btn-group" role="group"> <button type="button" class="btn btn-default" ng-click="filterGetWithCoupleEvents()" translate="WITHCOUPLE"></button> </div> <div class="btn-group" role="group"> <button type="button" class="btn btn-default" ng-click="filterGetSuprisedMeEvents()" translate="SUPRISEDME"></button> </div> </div> <br> <div class="container" ng-if="!showMsg"> <div class="row" style="display:flex; flex-wrap: wrap"> <div class="col-sm-12 col-md-4" ng-repeat="event in events"> <div class="thumbnail eventPreview" ng-controller="ShowEventDetailCtrl"> <img ng-click="showEventDetail(event.id)" class="img-event" ng-src="{{event.urlImg}}" alt="..."> <div class="caption"> <h4 ng-click="showEventDetail(event.id)">{{event.title}}</h4> </div> </div> </div> </div> </div> <br> <!-- FALTA PAGINACION -->'),a.put("views/search-events.html",'<div class="container"> <div class="row"> <div class="custom-search-input"> <div class="input-group col-md-12"> <input type="text" class="search-query form-control" ng-model="word" placeholder="{{\'SEARCH\' | translate}}"> <span class="input-group-btn"> <button ng-class="{\'disabled\' : !enableSearch()}" ng-click="searchEvents(1)" class="btn btn-default" type="button"> <span class="glyphicon glyphicon-search"></span> </button> </span> </div> </div> </div> </div> <div class="container" ng-if="showMsg"> <div class="text-center"> <h4> No hay resultados para esta busqueda! </h4> </div> </div> <div class="container" ng-if="!showMsg"> <div class="row" style="display:flex; flex-wrap: wrap"> <div class="col-sm-12 col-md-4" ng-repeat="event in events"> <div class="thumbnail eventPreview"> <img ng-click="showEventDetail(event.id)" class="img-event" ng-src="{{event.urlImg}}" alt="..."> <div class="caption"> <h4 ng-click="showEventDetail(event.id)">{{event.title}}</h4> </div> </div> </div> </div> <div id="paginationAllEvents" ng-if="!searching"> <div class="pagination-centered"> <nav aria-label="Page navigation"> <ul class="pagination"> <li> <a href aria-label="Previous" ng-if="actualPage > 1" ng-click="loadPage(actualPage - 1)"> <span aria-hidden="true">&laquo;</span> </a> </li> <li ng-class="{\'active\': activePage($index+1)}" ng-repeat="i in getPages(pages) track by $index"> <a href ng-click="loadPage($index+1)">{{$index+1}}</a> </li> <li> <a href aria-label="Next" ng-if="actualPage < pages" ng-click="loadPage(actualPage + 1)"> <span aria-hidden="true">&raquo;</span> </a> </li> </ul> </nav> </div> </div> <div id="paginationSearch" ng-if="searching"> <div class="pagination-centered"> <nav aria-label="Page navigation"> <ul class="pagination"> <li> <a href aria-label="Previous" ng-if="actualPage > 1" ng-click="searchEvents(actualPage - 1)"> <span aria-hidden="true">&laquo;</span> </a> </li> <li ng-class="{\'active\': activePage($index+1)}" ng-repeat="i in getPages(pagesForSearch) track by $index"> <a href ng-click="searchEvents($index+1)">{{$index+1}}</a> </li> <li> <a href aria-label="Next" ng-if="actualPage < pagesForSearch" ng-click="searchEvents(actualPage + 1)"> <span aria-hidden="true">&raquo;</span> </a> </li> </ul> </nav> </div> </div> </div>'),a.put("views/select-event-type.html",'<div class="container" ng-if="isAuthenticated"> <h3 class="text-center">Seleccionar tipo de evento</h3> <div class="row category-child" style="margin-top:20px"> <div class="col-md-4 thumb pointer"> <a class="thumbnail" ng-click="selectEventType(\'music\')"> <img class="img-responsive" src="/images/music.ico" alt=""> <div class="wrapper"> <div class="caption post-content"> <span>Música</span> </div> </div> </a> </div> <div class="col-md-4 thumb pointer"> <a class="thumbnail" ng-click="selectEventType(\'movie\')"> <img class="img-responsive" src="/images/movie.f9e239cb.png" alt=""> <div class="wrapper"> <div class="caption post-content"> <span>Cine</span> </div> </div> </a> </div> <div class="col-md-4 thumb pointer"> <a class="thumbnail" ng-click="selectEventType(\'food\')"> <img class="img-responsive" src="/images/food.e91b1c63.png" alt=""> <div class="wrapper"> <div class="caption post-content"> <span>Gastronomía</span> </div> </div> </a> </div> </div> </div>')}]);