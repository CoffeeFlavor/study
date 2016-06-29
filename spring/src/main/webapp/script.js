navigator.getUserMedia = navigator.getUserMedia ||
    navigator.webkitGetUserMedia ||
    navigator.mozGetUserMedia;

if (navigator.getUserMedia) {
    navigator.getUserMedia({ audio: true, video: { width: 1280, height: 720 } },
        function(stream) {
            var video = document.querySelector('video');
            video.src = window.URL.createObjectURL(stream);
            video.onloadedmetadata = function(e) {
                video.play();
            };
        },
        function(err) {
            console.log("The following error occurred: " + err.name);
        }
    );
} else {
    console.log("getUserMedia not supported");
}

function recognize(){
    var oldCanvas = under.toDataURL("image/png");
    console.info(oldCanvas);
}