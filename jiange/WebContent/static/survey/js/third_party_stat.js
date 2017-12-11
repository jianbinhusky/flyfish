jQuery(document).ready(function($) {
    // var _gaq = _gaq || [];
    // _gaq.push(['_setAccount', 'UA-9592313-3']);
    // _gaq.push(['_trackPageview']);

    // (function() {
    //     var ga = document.createElement('script');
    //     ga.type = 'text/javascript';
    //     ga.async = true;
    //     // ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    //     ga.src = '/static/js/google/analytics.js';
    //     var s = document.getElementsByTagName('script')[0];
    //     s.parentNode.insertBefore(ga, s);
    // })();
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
    (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
    m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','/static/js/google/analytics.js','ga');

    ga('create', 'UA-9592313-3', 'auto');
    ga('send', 'pageview');

    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?805c9a16950cbbec8732e90433c5a9e2";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();

    $(function() {
        $("a img[src='http://eiv.baidu.com/hmt/icon/21.gif']").hide();
    });

});