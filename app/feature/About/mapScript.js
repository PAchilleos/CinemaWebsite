function initMap(){
                var ourLocation = {lat:53.473844 , lng:-2.286267}
                var map = new google.maps.Map(document.getElementById("map"), {
                    zoom: 15,
                    center: ourLocation
        });
        var marker = new google.maps.Marker({
            position: ourLocation,
            map: map
        });
            }    