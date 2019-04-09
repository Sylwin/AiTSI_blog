package com.aitsi.project.blog.database;

import com.aitsi.project.blog.dao.Author;
import com.aitsi.project.blog.dao.Headline;
import com.aitsi.project.blog.dao.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Reader {

    public List<Author> retrieveAuthors() {
        List<Author> authorsList = new ArrayList<>();
        Author author1 = new Author("1", "John", "Smith",
                ("First blog author's description. Nunc molestie tellus quis magna pulvinar elementum. Praesent " +
                        "sodales sodales faucibus. Etiam nulla libero, commodo eget nibh in, viverra porta ante. Orci" +
                        " varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.Sed scelerisque feugiat ipsum nec tempor. Fusce faucibus ex ut ex commodo, eu aliquam arcu interdum. Aenean faucibus metus et dui ornare, ac fringilla lacus finibus. Aenean mollis, augue eget mattis ornare, mauris ligula fringilla risus, in rhoncus purus nibh sed justo. In imperdiet massa ac dui cursus, sed placerat felis sagittis."),
                "author1.jpg");
        authorsList.add(author1);
        Author author2 = new Author("2", "Mary", "Smith",
                ("Second blog author's description. Nunc molestie tellus quis magna pulvinar elementum. Praesent " +
                        "sodales sodales faucibus. Etiam nulla libero, commodo eget nibh in, viverra porta ante. Orci" +
                        " varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.Sed scelerisque feugiat ipsum nec tempor. Fusce faucibus ex ut ex commodo, eu aliquam arcu interdum. Aenean faucibus metus et dui ornare, ac fringilla lacus finibus. Aenean mollis, augue eget mattis ornare, mauris ligula fringilla risus, in rhoncus purus nibh sed justo. In imperdiet massa ac dui cursus, sed placerat felis sagittis."),
                "author2.jpg");
        authorsList.add(author2);
        return authorsList;
    }

    public List<Post> retrievePosts() {
        List<Post> postsList = new ArrayList<>();
        Post post1 = new Post("1", "First adventure", "Geneva",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, aenean porttitor efficitur purus, ut " +
                        "commodo ipsum, curabitur cursus, ex eu aliquam congu. Erat nibh mattis nisi, quis interdum mi ipsum eget lorem. Cras quis quam ligula. Aliquam erat volutpat. Donec ornare varius risus, eget aliquet nulla tempus at. Sed congue nunc lobortis, pulvinar nunc id, fringilla odio. Vestibulum eleifend, mauris quis sodales porttitor, est elit molestie nisi, quis dictum augue ipsum non erat. Etiam dignissim dictum est. Proin vulputate in lorem ut imperdiet. Curabitur ut facilisis nisi.\\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tempor, velit ut molestie pulvinar, risus neque facilisis diam, non consectetur est magna et dui. Praesent pharetra massa tortor, vel aliquam libero aliquam sed. Praesent arcu mauris, pretium sit amet turpis ac, tincidunt laoreet ante. Praesent consequat a odio quis laoreet. Nunc velit dui, porttitor vel lectus tempor, sagittis rhoncus urna. Nulla ornare ipsum sit amet tristique accumsan. Phasellus eleifend dui sit amet ornare efficitur. Phasellus suscipit nulla elit, non pharetra mi lobortis eu. Pellentesque ac tellus vitae libero efficitur viverra vitae ut velit. Mauris vel mi vitae nulla elementum tempor sit amet ut ipsum. Sed sed tortor vehicula, varius urna at, ullamcorper orci. Quisque id erat sed augue condimentum elementum sed in elit. Aliquam vitae magna eget magna viverra fringilla in quis leo. Mauris suscipit orci sit amet tortor vulputate egestas. Vestibulum posuere massa nisi, eget accumsan dolor sollicitudin quis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\\nDonec semper non elit vitae fringilla. Nulla facilisi. Integer nec scelerisque dolor. Suspendisse varius tellus porta augue sollicitudin interdum. Aliquam consequat, est vel porttitor rutrum, lacus nulla vulputate orci, sed blandit risus est at felis. Mauris a eros ac metus convallis condimentum. In eget aliquam ipsum, posuere imperdiet nunc. Praesent dapibus auctor dui sit amet fermentum. Cras quis metus rutrum, condimentum ipsum sed, faucibus neque.\\nCurabitur porta sapien sed neque iaculis gravida. In rhoncus sapien at ex sodales, at porttitor nulla imperdiet. Ut condimentum leo eget posuere hendrerit. Vivamus pharetra nibh iaculis mi aliquet volutpat. Etiam varius ullamcorper diam eu mattis. Cras lacinia facilisis scelerisque. Maecenas placerat ornare risus volutpat porttitor. Sed varius convallis cursus. Integer ac arcu mauris. Cras in purus cursus, condimentum est et, laoreet ligula. Mauris lacus sapien, faucibus id iaculis vitae, tincidunt sed est. Nunc euismod est at elementum accumsan. Nulla iaculis tellus ac orci rhoncus semper. Ut elit erat, placerat et accumsan congue, scelerisque eu enim.\\nNam id lorem nunc. Etiam placerat ipsum lorem, sit amet volutpat erat vestibulum eget. Pellentesque eget felis pretium, pellentesque tortor eu, faucibus tellus. Aenean porttitor finibus ornare. Cras eget sodales neque, sed fermentum felis. Mauris et mi accumsan, cursus sapien quis, elementum nibh. Proin a lectus feugiat, mollis nisi nec, aliquam libero. Nulla porta ac eros sed cursus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut facilisis porta leo et varius. Aliquam erat volutpat. Aliquam erat volutpat. Nunc ac nisl ac diam molestie molestie. Phasellus sagittis ultrices libero, non ornare elit aliquam eu. Vestibulum luctus malesuada ex, vitae luctus eros porta ac. Nullam faucibus nisi mauris, ac venenatis justo maximus malesuada.\\nVestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vestibulum egestas rutrum porttitor. Integer convallis iaculis tristique. Vivamus condimentum pretium est, ut laoreet lacus elementum vel. Suspendisse nunc magna, fermentum ac consequat sit amet, dictum at eros. Suspendisse venenatis turpis sapien, non aliquet enim tincidunt eget. Vestibulum luctus id velit vel faucibus. In non felis quis nulla congue feugiat. Duis metus augue, elementum nec tincidunt eu, porttitor vel eros. Praesent tincidunt, nisl quis sagittis molestie, dui leo aliquet eros, id congue dolor ex non lectus. Nulla neque augue, maximus vitae tellus sit amet, bibendum consequat mi. Vestibulum nec suscipit sapien.",
                "13.jpg", new ArrayList<String>() {{
            add("1.1.jpg");
            add("1.2.jpg");
            add("1.3.jpg");
            add("3.1.jpg");
            add("4.2.jpg");
            add("3.3.jpg");
            add("3.4.jpg");
        }}, "15-10-2018");
        Post post2 = new Post("2", "Second adventure", "Toscany", "Nullam at urna consectetur, convallis risus " +
                "at, volutpat risus, mauris ornare eu ligula sit amet ultricies pellentesque venenatis sapien a erat vehicula. Ac pellentesque elit scelerisque. Mauris luctus suscipit mi, ut vulputate arcu interdum mollis. Proin vel lorem justo. Morbi venenatis ullamcorper eros, sit amet pharetra elit posuere at. Proin ultrices, eros vitae semper dictum, ante ex euismod lectus, vitae lobortis ante elit non diam. Duis a augue commodo, dignissim dolor quis, vulputate quam. Praesent semper non augue a ullamcorper. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer erat urna, dictum congue velit quis, elementum mollis dolor. Phasellus aliquet interdum tortor, eu lacinia eros scelerisque sit amet. Vivamus non nisl sit amet arcu hendrerit hendrerit non fermentum dolor. Praesent ultrices turpis in dui vestibulum mattis.\\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tempor, velit ut molestie pulvinar, risus neque facilisis diam, non consectetur est magna et dui. Praesent pharetra massa tortor, vel aliquam libero aliquam sed. Praesent arcu mauris, pretium sit amet turpis ac, tincidunt laoreet ante. Praesent consequat a odio quis laoreet. Nunc velit dui, porttitor vel lectus tempor, sagittis rhoncus urna. Nulla ornare ipsum sit amet tristique accumsan. Phasellus eleifend dui sit amet ornare efficitur. Phasellus suscipit nulla elit, non pharetra mi lobortis eu. Pellentesque ac tellus vitae libero efficitur viverra vitae ut velit. Mauris vel mi vitae nulla elementum tempor sit amet ut ipsum. Sed sed tortor vehicula, varius urna at, ullamcorper orci. Quisque id erat sed augue condimentum elementum sed in elit. Aliquam vitae magna eget magna viverra fringilla in quis leo. Mauris suscipit orci sit amet tortor vulputate egestas. Vestibulum posuere massa nisi, eget accumsan dolor sollicitudin quis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\\nDonec semper non elit vitae fringilla. Nulla facilisi. Integer nec scelerisque dolor. Suspendisse varius tellus porta augue sollicitudin interdum. Aliquam consequat, est vel porttitor rutrum, lacus nulla vulputate orci, sed blandit risus est at felis. Mauris a eros ac metus convallis condimentum. In eget aliquam ipsum, posuere imperdiet nunc. Praesent dapibus auctor dui sit amet fermentum. Cras quis metus rutrum, condimentum ipsum sed, faucibus neque.\\nCurabitur porta sapien sed neque iaculis gravida. In rhoncus sapien at ex sodales, at porttitor nulla imperdiet. Ut condimentum leo eget posuere hendrerit. Vivamus pharetra nibh iaculis mi aliquet volutpat. Etiam varius ullamcorper diam eu mattis. Cras lacinia facilisis scelerisque. Maecenas placerat ornare risus volutpat porttitor. Sed varius convallis cursus. Integer ac arcu mauris. Cras in purus cursus, condimentum est et, laoreet ligula. Mauris lacus sapien, faucibus id iaculis vitae, tincidunt sed est. Nunc euismod est at elementum accumsan. Nulla iaculis tellus ac orci rhoncus semper. Ut elit erat, placerat et accumsan congue, scelerisque eu enim.\\nNam id lorem nunc. Etiam placerat ipsum lorem, sit amet volutpat erat vestibulum eget. Pellentesque eget felis pretium, pellentesque tortor eu, faucibus tellus. Aenean porttitor finibus ornare. Cras eget sodales neque, sed fermentum felis. Mauris et mi accumsan, cursus sapien quis, elementum nibh. Proin a lectus feugiat, mollis nisi nec, aliquam libero. Nulla porta ac eros sed cursus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut facilisis porta leo et varius. Aliquam erat volutpat. Aliquam erat volutpat. Nunc ac nisl ac diam molestie molestie. Phasellus sagittis ultrices libero, non ornare elit aliquam eu. Vestibulum luctus malesuada ex, vitae luctus eros porta ac. Nullam faucibus nisi mauris, ac venenatis justo maximus malesuada.\\nVestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vestibulum egestas rutrum porttitor. Integer convallis iaculis tristique. Vivamus condimentum pretium est, ut laoreet lacus elementum vel. Suspendisse nunc magna, fermentum ac consequat sit amet, dictum at eros. Suspendisse venenatis turpis sapien, non aliquet enim tincidunt eget. Vestibulum luctus id velit vel faucibus. In non felis quis nulla congue feugiat. Duis metus augue, elementum nec tincidunt eu, porttitor vel eros. Praesent tincidunt, nisl quis sagittis molestie, dui leo aliquet eros, id congue dolor ex non lectus. Nulla neque augue, maximus vitae tellus sit amet, bibendum consequat mi. Vestibulum nec suscipit sapien.",
                "5.jpg", new ArrayList<String>() {{
            add("2.1.jpg");
            add("2.2.jpg");
            add("4.1.jpg");
            add("4.2.jpg");
            add("1.1.jpg");
            add("1.2.jpg");
            add("1.3.jpg");
            add("5.1.jpg");
            add("1.3.jpg");
            add("5.2.jpg");
            add("3.1.jpg");
            add("3.3.jpg");
        }},
                "07-11-2018");
        Post post3 = new Post("3", "Third adventure", "Norway", "Nunc vel fermentum libero, nulla faucibus, nibh " +
                "eget bibendum consequat, mi orci lobortis tellus, eu luctus purus tortor et metu, aliquam erat volutpat. Nunc consequat purus nulla, vel eleifend ipsum sollicitudin et. In sagittis, mauris ac tincidunt molestie, arcu diam pharetra dolor, eget sagittis felis mi sed dolor. Sed vitae ullamcorper urna. Praesent molestie metus vitae tortor aliquet interdum. Ut mattis aliquet lorem eget ullamcorper. Morbi ornare eleifend dolor, in maximus justo consectetur a. Mauris pulvinar sodales erat. Sed eu malesuada ex, non dapibus nisi. Mauris nec sapien commodo, vehicula magna et, sodales quam. Integer varius est ac felis facilisis tristique.\\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tempor, velit ut molestie pulvinar, risus neque facilisis diam, non consectetur est magna et dui. Praesent pharetra massa tortor, vel aliquam libero aliquam sed. Praesent arcu mauris, pretium sit amet turpis ac, tincidunt laoreet ante. Praesent consequat a odio quis laoreet. Nunc velit dui, porttitor vel lectus tempor, sagittis rhoncus urna. Nulla ornare ipsum sit amet tristique accumsan. Phasellus eleifend dui sit amet ornare efficitur. Phasellus suscipit nulla elit, non pharetra mi lobortis eu. Pellentesque ac tellus vitae libero efficitur viverra vitae ut velit. Mauris vel mi vitae nulla elementum tempor sit amet ut ipsum. Sed sed tortor vehicula, varius urna at, ullamcorper orci. Quisque id erat sed augue condimentum elementum sed in elit. Aliquam vitae magna eget magna viverra fringilla in quis leo. Mauris suscipit orci sit amet tortor vulputate egestas. Vestibulum posuere massa nisi, eget accumsan dolor sollicitudin quis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\\nDonec semper non elit vitae fringilla. Nulla facilisi. Integer nec scelerisque dolor. Suspendisse varius tellus porta augue sollicitudin interdum. Aliquam consequat, est vel porttitor rutrum, lacus nulla vulputate orci, sed blandit risus est at felis. Mauris a eros ac metus convallis condimentum. In eget aliquam ipsum, posuere imperdiet nunc. Praesent dapibus auctor dui sit amet fermentum. Cras quis metus rutrum, condimentum ipsum sed, faucibus neque.\\nCurabitur porta sapien sed neque iaculis gravida. In rhoncus sapien at ex sodales, at porttitor nulla imperdiet. Ut condimentum leo eget posuere hendrerit. Vivamus pharetra nibh iaculis mi aliquet volutpat. Etiam varius ullamcorper diam eu mattis. Cras lacinia facilisis scelerisque. Maecenas placerat ornare risus volutpat porttitor. Sed varius convallis cursus. Integer ac arcu mauris. Cras in purus cursus, condimentum est et, laoreet ligula. Mauris lacus sapien, faucibus id iaculis vitae, tincidunt sed est. Nunc euismod est at elementum accumsan. Nulla iaculis tellus ac orci rhoncus semper. Ut elit erat, placerat et accumsan congue, scelerisque eu enim.\\nNam id lorem nunc. Etiam placerat ipsum lorem, sit amet volutpat erat vestibulum eget. Pellentesque eget felis pretium, pellentesque tortor eu, faucibus tellus. Aenean porttitor finibus ornare. Cras eget sodales neque, sed fermentum felis. Mauris et mi accumsan, cursus sapien quis, elementum nibh. Proin a lectus feugiat, mollis nisi nec, aliquam libero. Nulla porta ac eros sed cursus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut facilisis porta leo et varius. Aliquam erat volutpat. Aliquam erat volutpat. Nunc ac nisl ac diam molestie molestie. Phasellus sagittis ultrices libero, non ornare elit aliquam eu. Vestibulum luctus malesuada ex, vitae luctus eros porta ac. Nullam faucibus nisi mauris, ac venenatis justo maximus malesuada.\\nVestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vestibulum egestas rutrum porttitor. Integer convallis iaculis tristique. Vivamus condimentum pretium est, ut laoreet lacus elementum vel. Suspendisse nunc magna, fermentum ac consequat sit amet, dictum at eros. Suspendisse venenatis turpis sapien, non aliquet enim tincidunt eget. Vestibulum luctus id velit vel faucibus. In non felis quis nulla congue feugiat. Duis metus augue, elementum nec tincidunt eu, porttitor vel eros. Praesent tincidunt, nisl quis sagittis molestie, dui leo aliquet eros, id congue dolor ex non lectus. Nulla neque augue, maximus vitae tellus sit amet, bibendum consequat mi. Vestibulum nec suscipit sapien.",
                "6.jpg", new ArrayList<String>() {{
            add("3.1.jpg");
            add("4.2.jpg");
            add("3.3.jpg");
            add("2.1.jpg");
            add("2.2.jpg");
            add("3.4.jpg");
            add("1.1.jpg");
            add("1.2.jpg");
            add("1.3.jpg");
        }}, "28-11-2018");
        Post post4 = new Post("4", "Fourth adventure", "Montenegro", "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, aenean porttitor efficitur purus, ut commodo ipsum curabitur cursus, ex eu aliquam congue. Erat nibh mattis nisi, quis interdum mi ipsum eget lorem. Cras quis quam ligula. Aliquam erat volutpat. Donec ornare varius risus, eget aliquet nulla tempus at. Sed congue nunc lobortis, pulvinar nunc id, fringilla odio. Vestibulum eleifend, mauris quis sodales porttitor, est elit molestie nisi, quis dictum augue ipsum non erat. Etiam dignissim dictum est. Proin vulputate in lorem ut imperdiet. Curabitur ut facilisis nisi.\\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tempor, velit ut molestie pulvinar, risus neque facilisis diam, non consectetur est magna et dui. Praesent pharetra massa tortor, vel aliquam libero aliquam sed. Praesent arcu mauris, pretium sit amet turpis ac, tincidunt laoreet ante. Praesent consequat a odio quis laoreet. Nunc velit dui, porttitor vel lectus tempor, sagittis rhoncus urna. Nulla ornare ipsum sit amet tristique accumsan. Phasellus eleifend dui sit amet ornare efficitur. Phasellus suscipit nulla elit, non pharetra mi lobortis eu. Pellentesque ac tellus vitae libero efficitur viverra vitae ut velit. Mauris vel mi vitae nulla elementum tempor sit amet ut ipsum. Sed sed tortor vehicula, varius urna at, ullamcorper orci. Quisque id erat sed augue condimentum elementum sed in elit. Aliquam vitae magna eget magna viverra fringilla in quis leo. Mauris suscipit orci sit amet tortor vulputate egestas. Vestibulum posuere massa nisi, eget accumsan dolor sollicitudin quis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\\nDonec semper non elit vitae fringilla. Nulla facilisi. Integer nec scelerisque dolor. Suspendisse varius tellus porta augue sollicitudin interdum. Aliquam consequat, est vel porttitor rutrum, lacus nulla vulputate orci, sed blandit risus est at felis. Mauris a eros ac metus convallis condimentum. In eget aliquam ipsum, posuere imperdiet nunc. Praesent dapibus auctor dui sit amet fermentum. Cras quis metus rutrum, condimentum ipsum sed, faucibus neque.\\nCurabitur porta sapien sed neque iaculis gravida. In rhoncus sapien at ex sodales, at porttitor nulla imperdiet. Ut condimentum leo eget posuere hendrerit. Vivamus pharetra nibh iaculis mi aliquet volutpat. Etiam varius ullamcorper diam eu mattis. Cras lacinia facilisis scelerisque. Maecenas placerat ornare risus volutpat porttitor. Sed varius convallis cursus. Integer ac arcu mauris. Cras in purus cursus, condimentum est et, laoreet ligula. Mauris lacus sapien, faucibus id iaculis vitae, tincidunt sed est. Nunc euismod est at elementum accumsan. Nulla iaculis tellus ac orci rhoncus semper. Ut elit erat, placerat et accumsan congue, scelerisque eu enim.\\nNam id lorem nunc. Etiam placerat ipsum lorem, sit amet volutpat erat vestibulum eget. Pellentesque eget felis pretium, pellentesque tortor eu, faucibus tellus. Aenean porttitor finibus ornare. Cras eget sodales neque, sed fermentum felis. Mauris et mi accumsan, cursus sapien quis, elementum nibh. Proin a lectus feugiat, mollis nisi nec, aliquam libero. Nulla porta ac eros sed cursus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut facilisis porta leo et varius. Aliquam erat volutpat. Aliquam erat volutpat. Nunc ac nisl ac diam molestie molestie. Phasellus sagittis ultrices libero, non ornare elit aliquam eu. Vestibulum luctus malesuada ex, vitae luctus eros porta ac. Nullam faucibus nisi mauris, ac venenatis justo maximus malesuada.\\nVestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vestibulum egestas rutrum porttitor. Integer convallis iaculis tristique. Vivamus condimentum pretium est, ut laoreet lacus elementum vel. Suspendisse nunc magna, fermentum ac consequat sit amet, dictum at eros. Suspendisse venenatis turpis sapien, non aliquet enim tincidunt eget. Vestibulum luctus id velit vel faucibus. In non felis quis nulla congue feugiat. Duis metus augue, elementum nec tincidunt eu, porttitor vel eros. Praesent tincidunt, nisl quis sagittis molestie, dui leo aliquet eros, id congue dolor ex non lectus. Nulla neque augue, maximus vitae tellus sit amet, bibendum consequat mi. Vestibulum nec suscipit sapien.",
                "7.jpg", new ArrayList<String>() {{
            add("4.1.jpg");
            add("4.2.jpg");
            add("1.1.jpg");
            add("1.2.jpg");
            add("1.3.jpg");
            add("3.1.jpg");
            add("5.2.jpg");
            add("3.4.jpg");
        }}, "05-12-2018");
        Post post5 = new Post("5", "Fifth adventure", "Austria", "Nunc vel fermentum libero, nulla faucibus, nibh" +
                " eget bibendum consequat, mi orci lobortis tellus, eu luctus purus tortor et metus, aliquam erat volutpat. Nunc consequat purus nulla, vel eleifend ipsum sollicitudin et. In sagittis, mauris ac tincidunt molestie, arcu diam pharetra dolor, eget sagittis felis mi sed dolor. Sed vitae ullamcorper urna. Praesent molestie metus vitae tortor aliquet interdum. Ut mattis aliquet lorem eget ullamcorper. Morbi ornare eleifend dolor, in maximus justo consectetur a. Mauris pulvinar sodales erat. Sed eu malesuada ex, non dapibus nisi. Mauris nec sapien commodo, vehicula magna et, sodales quam. Integer varius est ac felis facilisis tristique.\\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Proin tempor, velit ut molestie pulvinar, risus neque facilisis diam, non consectetur est magna et dui. Praesent pharetra massa tortor, vel aliquam libero aliquam sed. Praesent arcu mauris, pretium sit amet turpis ac, tincidunt laoreet ante. Praesent consequat a odio quis laoreet. Nunc velit dui, porttitor vel lectus tempor, sagittis rhoncus urna. Nulla ornare ipsum sit amet tristique accumsan. Phasellus eleifend dui sit amet ornare efficitur. Phasellus suscipit nulla elit, non pharetra mi lobortis eu. Pellentesque ac tellus vitae libero efficitur viverra vitae ut velit. Mauris vel mi vitae nulla elementum tempor sit amet ut ipsum. Sed sed tortor vehicula, varius urna at, ullamcorper orci. Quisque id erat sed augue condimentum elementum sed in elit. Aliquam vitae magna eget magna viverra fringilla in quis leo. Mauris suscipit orci sit amet tortor vulputate egestas. Vestibulum posuere massa nisi, eget accumsan dolor sollicitudin quis. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\\nDonec semper non elit vitae fringilla. Nulla facilisi. Integer nec scelerisque dolor. Suspendisse varius tellus porta augue sollicitudin interdum. Aliquam consequat, est vel porttitor rutrum, lacus nulla vulputate orci, sed blandit risus est at felis. Mauris a eros ac metus convallis condimentum. In eget aliquam ipsum, posuere imperdiet nunc. Praesent dapibus auctor dui sit amet fermentum. Cras quis metus rutrum, condimentum ipsum sed, faucibus neque.\\nCurabitur porta sapien sed neque iaculis gravida. In rhoncus sapien at ex sodales, at porttitor nulla imperdiet. Ut condimentum leo eget posuere hendrerit. Vivamus pharetra nibh iaculis mi aliquet volutpat. Etiam varius ullamcorper diam eu mattis. Cras lacinia facilisis scelerisque. Maecenas placerat ornare risus volutpat porttitor. Sed varius convallis cursus. Integer ac arcu mauris. Cras in purus cursus, condimentum est et, laoreet ligula. Mauris lacus sapien, faucibus id iaculis vitae, tincidunt sed est. Nunc euismod est at elementum accumsan. Nulla iaculis tellus ac orci rhoncus semper. Ut elit erat, placerat et accumsan congue, scelerisque eu enim.\\nNam id lorem nunc. Etiam placerat ipsum lorem, sit amet volutpat erat vestibulum eget. Pellentesque eget felis pretium, pellentesque tortor eu, faucibus tellus. Aenean porttitor finibus ornare. Cras eget sodales neque, sed fermentum felis. Mauris et mi accumsan, cursus sapien quis, elementum nibh. Proin a lectus feugiat, mollis nisi nec, aliquam libero. Nulla porta ac eros sed cursus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Ut facilisis porta leo et varius. Aliquam erat volutpat. Aliquam erat volutpat. Nunc ac nisl ac diam molestie molestie. Phasellus sagittis ultrices libero, non ornare elit aliquam eu. Vestibulum luctus malesuada ex, vitae luctus eros porta ac. Nullam faucibus nisi mauris, ac venenatis justo maximus malesuada.\\nVestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Vestibulum egestas rutrum porttitor. Integer convallis iaculis tristique. Vivamus condimentum pretium est, ut laoreet lacus elementum vel. Suspendisse nunc magna, fermentum ac consequat sit amet, dictum at eros. Suspendisse venenatis turpis sapien, non aliquet enim tincidunt eget. Vestibulum luctus id velit vel faucibus. In non felis quis nulla congue feugiat. Duis metus augue, elementum nec tincidunt eu, porttitor vel eros. Praesent tincidunt, nisl quis sagittis molestie, dui leo aliquet eros, id congue dolor ex non lectus. Nulla neque augue, maximus vitae tellus sit amet, bibendum consequat mi. Vestibulum nec suscipit sapien.",
                "9.jpg", new ArrayList<String>() {{
            add("5.1.jpg");
            add("2.1.jpg");
            add("2.2.jpg");
            add("5.2.jpg");
            add("3.3.jpg");
            add("3.4.jpg");
            add("1.1.jpg");
            add("1.2.jpg");
            add("1.3.jpg");
        }}, "18-01-2019");
        postsList.add(post1);
        postsList.add(post2);
        postsList.add(post3);
        postsList.add(post4);
        postsList.add(post5);
        return postsList;
    }

    public List<Headline> retrieveHeadlines() {
        List<Headline> headlineList = new ArrayList<>();
        Headline headline1 = new Headline("1", "First headline.", "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit. Nullam eu ornare lorem, vitae commodo purus. Nulla suscipit at lectus non convallis" +
                ". Donec fermentum lacus sed sodales laoreet. Mauris sed quam hendrerit nisi condimentum consequat.",
                "2.jpg");
        Headline headline2 = new Headline("2", "Second headline.", "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit. Nullam eu ornare lorem, vitae commodo purus. Nulla suscipit at lectus non convallis" +
                ". Donec fermentum lacus sed sodales laoreet. Mauris sed quam hendrerit nisi condimentum consequat.",
                "1.jpg");
        Headline headline3 = new Headline("3", "Third headline.", "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit. Nullam eu ornare lorem, vitae commodo purus. Nulla suscipit at lectus non convallis" +
                ". Donec fermentum lacus sed sodales laoreet. Mauris sed quam hendrerit nisi condimentum consequat.",
                "3.jpg");
        headlineList.add(headline1);
        headlineList.add(headline2);
        headlineList.add(headline3);
        return headlineList;
    }
}