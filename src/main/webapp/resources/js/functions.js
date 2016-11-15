/**
 * 
 */
function show_dados(){
	$('#dados').removeClass('hidden')
	$('#senha').addClass('hidden')
	$('#notificacao').addClass('hidden')

	$('#nav_dados').addClass('active')
	$('#nav_senha').removeClass('active')
	$('#nav_notificacao').removeClass('active')
}

function show_senha(){
	$('#dados').addClass('hidden')
	$('#senha').removeClass('hidden')
	$('#notificacao').addClass('hidden')

	$('#nav_dados').removeClass('active')
	$('#nav_senha').addClass('active')
	$('#nav_notificacao').removeClass('active')
}

function show_notificacao(){
	$('#dados').addClass('hidden')
	$('#senha').addClass('hidden')
	$('#notificacao').removeClass('hidden')

	$('#nav_dados').removeClass('active')
	$('#nav_senha').removeClass('active')
	$('#nav_notificacao').addClass('active')
}