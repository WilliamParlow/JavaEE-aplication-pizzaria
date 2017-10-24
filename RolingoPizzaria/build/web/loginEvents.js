/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const LOADING_DELAY = 300;

$(document).ready(function () {

    $('.lds-dual-ring').fadeOut(LOADING_DELAY, function () {

        $('#dualRingLoading').fadeOut();

    });
    
    $('input').focus(function() {
        
       $('input').removeClass('invalid-form-input');
       $('.invalid-text-form').html('');
        
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

        $('#dualRingLoading').fadeIn(function () {

            $('.lds-dual-ring').fadeIn();

        });

        $.ajax({

            method: "POST",
            url: "login/UserAuthenticationServlet?login=" + login + "&passwd=" + passwd,
            success: function (response) {

                $('.lds-dual-ring').fadeOut(LOADING_DELAY, function () {

                    $('#dualRingLoading').fadeOut();

                });

                console.log(response);

                if (!response.success && response.success) {

                    try {
                        
                        let errDescriptions = '';

                        Object.keys(response.errors).forEach(function (error) {
                            console.log(response.errors[error].description);
                            errDescriptions = errDescriptions.concat(response.errors[error].description);
                        });
                        
                        $('.invalid-text-form').html(errDescriptions);
                        $('input').addClass('invalid-form-input');

                    } catch (err) {
                        console.warn(err);
                        $('.invalid-text-form').html(err);
                        $('input').addClass('invalid-form-input');
                    }

                    return;

                } else {
                    $('body').html(response);
                }

            },
            error: function (err) {

                console.log(err);

                $('.lds-dual-ring').fadeOut(LOADING_DELAY, function () {

                    $('#dualRingLoading').fadeOut();

                });

            }

        });

    });
    
    $('#signup').submit(function (event) {

        event.preventDefault();

        let login = $(event.target).find('input[name=login]').val();
        let passwd = $(event.target).find('input[name=passwd]').val();
        let name = $(event.target).find('input[name=name]').val();

        $('#dualRingLoading').fadeIn(function () {

            $('.lds-dual-ring').fadeIn();

        });

        $.ajax({

            method: "POST",
            url: "login/CreateNewUser?name=" + name + "&login=" + login + "&passwd=" + passwd,
            success: function (response) {

                $('.lds-dual-ring').fadeOut(LOADING_DELAY, function () {

                    $('#dualRingLoading').fadeOut();

                });

                console.log(response);

                if (!response.success) {

                    try {
                        
                        let errDescriptions = '';

                        Object.keys(response.errors).forEach(function (error) {
                            console.log(response.errors[error].description);
                            errDescriptions = errDescriptions.concat(response.errors[error].description);
                        });
                        
                        $('.invalid-text-form').html(errDescriptions);
                        $('input').addClass('invalid-form-input');

                    } catch (err) {
                        console.warn(err);
                        $('.invalid-text-form').html(err);
                        $('input').addClass('invalid-form-input');
                    }

                    return;

                } else {
                    $('body').html(response);
                }

            },
            error: function (err) {

                console.log(err);

                $('.lds-dual-ring').fadeOut(LOADING_DELAY, function () {

                    $('#dualRingLoading').fadeOut();

                });

            }

        });

    });

})

function costomTogleClass(htmlElement, className, trigger) {

    (trigger()) ? $(htmlElement).addClass(className)
            : $(htmlElement).removeClass(className);

}