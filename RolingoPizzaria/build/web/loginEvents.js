/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    $(document).ready(function () {

        $('.lds-dual-ring').fadeOut(1000, function () {

            $('#dualRingLoading').fadeOut();

        });

    });

    $('.form-toggler').click(function () {

        let fadeInTarget = $(this).data('fade_in_target');
        let fadeOutTarget = $(this).data('fade_out_target');

        $(fadeInTarget).toggleClass('fade-in');
        $(fadeOutTarget).toggleClass('fade-in');
        $(fadeInTarget).toggleClass('fade-out');
        $(fadeOutTarget).toggleClass('fade-out');

    })

    $('#signin').submit(function (event) {

        event.preventDefault();

        let login = $(event.target).find('input[name=login]').val();
        let passwd = $(event.target).find('input[name=passwd]').val();

        $.ajax({

            method: "POST",
            url: "login/UserAuthenticationServlet?login=" + login + "&passwd=" + passwd,
            success: function (response) {
                console.log(response);
                if (!response.success) {
                    try {
                        Object.keys(response.errors).forEach(function (error) {
                            console.log(response.errors[error].description);
                        });
                    } catch (err) {
                        console.error(err);
                    }
                    return;
                }
            },
            error: function (err) {
                console.log(err);
            }

        });

    })

})

function costomTogleClass(htmlElement, className, trigger) {

    (trigger()) ? $(htmlElement).addClass(className)
            : $(htmlElement).removeClass(className);

}