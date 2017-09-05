function initMap(){
                let ourLocation = {lat:53.473844 , lng:-2.286267}
                let map = new google.maps.Map(document.getElementById("map"), {
                    zoom: 15,
                    center: ourLocation
        });
        let marker = new google.maps.Marker({
            position: ourLocation,
            map: map
        });
            }    