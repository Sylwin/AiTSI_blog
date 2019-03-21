function retrieveBlog() {
    var url = '/find';
    var title = $('#searchBlog').val();

    if( title !== '' ) {
        title = title.replace(/\s/g, "_");
        url = url + '/' + title;
    }

    $("#resultsBlock").load(url);
}

function getNewestBlogs() {
    var url = '/get/newest';

    $("#resultsColumn").load(url);
}

function getOldestBlogs() {
    var url = '/get/oldest';

    $("#resultsColumn").load(url);
}

function getHighestRatedBlogs() {
    var url = '/get/highestRated';

    $("#resultsColumn").load(url);
}

// function updateLikes() {
//     var url = '/likes';
//
//     $("#likingTime").load(url);
// }
//
// function updateDislikes() {
//     var url = '/dislikes';
//
//     $("#dislikingTime").load(url);
// }