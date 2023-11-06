$(".submenu1").hover(function (e) {
  const content = $(e.target).next();

  $(".submenu2").slideUp();
  content.slideDown(500);
});
