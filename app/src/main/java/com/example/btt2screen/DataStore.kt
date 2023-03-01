package com.example.btt2screen

import androidx.lifecycle.MutableLiveData


class DataStore {
    companion object {
        var userDataStore: MutableList<MutableMap<String, String>> = mutableListOf(mutableMapOf(
            "fullName" to "Eljad Eendaz",
            "email" to "username@gmail.com",
            "password" to "12345678",
            "phoneNumber" to "+1 (783) 0986 8786"
        ))
        val currentUserData: MutableLiveData<MutableMap<String, String>> = MutableLiveData()
        val Restaurant: MutableLiveData<MutableList<Image>> = MutableLiveData(mutableListOf(

            Image(
                147114, "Hana BBQ & Hot Pot Buffet - Phan Văn Trị", "705 - 707 Phan Văn Trị, P. 7", "https://images.foody.vn/res/g15/147114/prof/s640x400/foody-mobile-14218097465_77c6d3a9-840-635745609441630967.jpg"
            ),
            Image(
                91979	,"SaiGon Chic Cafe"	,"82 Đường Số 27, P. 6"	,"https://images.foody.vn/res/g10/91979/prof/s640x400/foody-mobile-kjuxujry-jpg-982-635838930416211667.jpg"

            ),
            Image(
                129725	,"Bánh Mì Chảo & Món Ngon Hoa Việt - Quán Cô 3 Hậu"	,"36 Đường Số 18, P. 8"	,"https://images.foody.vn/res/g13/129725/prof/s640x400/foody-mobile-foody-quan-co-3-hau--960-635652896252263911.jpg"

            ),
            Image(
                158187	,"The Coffee House - Quang Trung"	,"293 Quang Trung"	,"https://images.foody.vn/res/g16/158187/prof/s640x400/foody-mobile-coffeehousequangtrun-822-635754530645782536.jpg"

            ),
            Image(
                232015	,"Cowboy Jack's - American Dining - Lotte Mart Gò Vấp"	,"Tầng 1, Lotte Mart Gò Vấp, 242 Nguyễn Văn Lượng, P. 10"	,"https://images.foody.vn/res/g24/232015/prof/s640x400/foody-mobile-untitled-1-jpg-931-636143900507885296.jpg"

            ),
//5

            Image(
                260306	,"Nhà Hàng Đùi Cừu Nướng - Tân Sơn"	,"395/2 Tân Sơn"	,"https://images.foody.vn/res/g27/260306/prof/s640x400/foody-mobile-c2-jpg-506-636051429704140905.jpg"

            ),
            Image(
                632537	,"Cơm Niêu Thanh Dung - Vincom Quang Trung"	,"Tầng B1 Vincom Quang Trung, 190 Quang Trung, P. 10"	,"https://images.foody.vn/res/g64/632537/prof/s640x400/foody-mobile-foody-com-nieu-thanh-267-636226007562347658.jpg"

            ),
            Image(
                243022	,"Rest - Milk Tea & Coffee"	,"233 Phạm Văn Đồng, P. 1"	,"https://images.foody.vn/res/g25/243022/prof/s640x400/foody-mobile-yummy-pucca-tra-sua--608-636008184788294962.jpg"

            ),
            Image(
                241191	,"Mì Cay & Cơm Chảo - Gia Hân Hân"	,"36 Đường 18, P. 8"	,"https://images.foody.vn/res/g25/241191/prof/s640x400/foody-mobile-1-jpg-859-636004798869374643.jpg"

            ),
            Image(
                102771	,"Cơm Tấm Loan - Nguyễn Thái Sơn"	,"346 Nguyễn Thái Sơn"	,"https://images.foody.vn/res/g11/102771/prof/s640x400/foody-mobile-mobile-jpg-273-636192952803833507.jpg"

            ),
//10

            Image(
                741810	,"Alô Cú Đêm - Ăn Đêm Online"	,"590/2/10 Phan Văn Trị, P. 7"	,"https://images.foody.vn/res/g75/741810/prof/s640x400/foody-upload-api-foody-mobile-hmbbd-jpg-180516153516.jpg"

            ),
            Image(
                646398	,"3T - Trà Sữa"	,"Hẻm 904 Nguyễn Kiệm, P. 3"	,"https://images.foody.vn/res/g65/646398/prof/s640x400/foody-mobile-t1-jpg-847-636262083036898539.jpg"

            ),
            Image(
                198048	,"Mahalo Beer Club - Quang Trung"	,"97 Quang Trung, P. 8"	,"https://images.foody.vn/res/g20/198048/prof/s640x400/foody-mobile-vinalo-1423450460c37-327-635864877923035553.jpg"

            ),
            Image(
                914781	,"Avatar Coffee & Tea - Nguyễn Văn Nghi"	,"27 Nguyễn Văn Nghi, P. 4"	,"https://images.foody.vn/res/g92/914781/prof/s640x400/foody-upload-api-foody-mobile-hjhjjh-190529101415.jpg"

            ),
            Image(
                78170	,"New Town Cafe - Phạm Văn Đồng"	,"226 Phạm Văn Đồng"	,"https://images.foody.vn/res/g8/78170/prof/s640x400/foody-mobile-31pjp7xp-jpg-544-636173040922508723.jpg"
            ),
//15

            Image(
                147404	,"Cháo Ếch Sư Phụ Singapore - Quang Trung"	,"143 Quang Trung, P. 10"	,"https://images.foody.vn/res/g15/147404/prof/s640x400/foody-mobile--20-_hinhmob-jpg-581-635711966218063586.jpg"
            ),
            Image(
                243368	,"Stir Crazy - Mongolian Grill/BBQ"	,"890 Quang Trung, P. 8"	,"https://images.foody.vn/res/g25/243368/prof/s640x400/foody-mobile-wa9x98f1-jpg-460-636027099847602421.jpg"

            ),
            Image(
                763311	,"Dumi Food & Cafe - Quang Trung"	,"777 Quang Trung, P. 12"	,"https://images.foody.vn/res/g77/763311/prof/s640x400/foody-upload-api-foody-mobile-6-190103151548.jpg"

            ),
            Image(
                228077	,"Lê Uyên - Trà Sữa Thạch Nhà Làm"	,"497 Thống Nhất, P. 16"	,"https://images.foody.vn/res/g23/228077/prof/s640x400/foody-mobile-c2-jpg-269-635962229479969754.jpg"

            ),
            Image(
                178062	,"Dê Tươi Mái Lá"	,"1 Huỳnh Văn Nghệ, P. 12"	,"https://images.foody.vn/res/g18/178062/prof/s640x400/foody-mobile-hmb-h-jpg-622-635809354088548078.jpg"

            ),
//20
        ))
    }
    }


