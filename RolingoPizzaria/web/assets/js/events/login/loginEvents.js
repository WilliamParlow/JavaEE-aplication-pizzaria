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

    $('.form-toggler').click(function () {

        let fadeInTarget = $(this).data('fade_in_target');
        let fadeOutTarget = $(this).data('fade_out_target');

        $(fadeInTarget).toggleClass('fade-in');
        $(fadeOutTarget).toggleClass('fade-in');
        $(fadeInTarget).toggleClass('fade-out');
        $(fadeOutTarget).toggleClass('fade-out');

    });

});