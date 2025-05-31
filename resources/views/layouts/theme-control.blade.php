<?php if(isset($_GET['theme'])){ ?>
    <script>
        <?php if($_GET['theme']=='dark-theme'){ ?>

            console.log("Dark");
            $("html").attr("class", "dark-theme");
            localStorage.setItem("theme",'dark-theme');

        <?php }else if($_GET['theme']=='semi-dark'){ ?>

            console.log("Semi Dark");
            $("html").attr("class", "semi-dark");
            localStorage.setItem("theme",'semi-dark');

        <?php }else{ ?>

            console.log("Light");
            $("html").attr("class", "light-theme");
            localStorage.setItem("theme","light-theme");

        <?php } ?>
    </script>
    <?php } ?>