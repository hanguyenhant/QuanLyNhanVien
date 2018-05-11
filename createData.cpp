#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int ngay, thang, nam;

char* createEmail(char* HD, char* T)
{
	static char email[64];
	int index = 0;
	for(int i = 0; i < strlen(HD); i++)
	{
		if (HD[i] != ' ')
		{
			email[index] = tolower(HD[i]);
			index++;
		}
	}

	for(int i = 0; i < strlen(T); i++)
	{
		email[index] = tolower(T[i]);
		index++;
	}

	email[index] = '\0';

	return email;
}

bool check()
{
	if (nam < 2017) return 1;
	else if ((nam == 2018) && (thang < 3)) return 1;
	else if ((nam == 2018) && (thang == 3) && (ngay < 31)) return 1;
	else return 0;
}

int maxDate()
{
	switch (thang)
	{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 2:
			{
				if (((nam%4 == 0)&&(nam%100)) || ((nam%100 == 0)&&(nam%400 == 0))) return 29;
				else return 28;
			}
		default:
			return 30;
	}
}
int  dayofweek(int y, int m, int d)  /* 1 <= m <= 12,  y > 1752 (in the U.K.) */
{
    static int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
    y -= m < 3;
    return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7; /* returns 0 = Sunday, 1 = Monday*/
}
void plusDate()
{
	ngay ++;
	if (ngay  > maxDate())
	{
		ngay = 1;
		thang++;
		if (thang > 12)
		{
			thang = 1;
			nam ++;
		}
	}



}

main()
{
	char* hoDem[] = {"Nguyen Van", "Do", "Vuong Chi", "Tran Van", "Pham Dang", "Vu Dinh", "Nguyen Son", "Le Hoang", "Nguyen Xuan", "Kieu", "Do Thi", "Nguyen Thi", "Vu Hong", "Pham Khanh", "Dinh Thi"};
	char* ten[] = {"Hung", "Son", "Lan", "Tai", "Doan", "Hieu", "Thao", "Tien", "Tiep", "Ly", "Mai", "Dung", "Toan", "Dung", "Viet", "Trinh", "Duong", "Hanh", "Hien", "Van", "Nam"};
	char* phong[] = {"Phong nhan su", "Phong tai chinh", "Phong ke toan", "Phong sang tao", "Phong tap vu" };
	char* congTy[] = {"BK Entertainment", "BK Food", "BK Tech"};
	char* tinhThanh[] = {"Ha Noi", "Hai Phong", "Thai Binh", "Nam Dinh", "Ninh Binh", "Quang Ninh", "Hai Duong", "Hung Yen", "Ha Nam", "Nghe An"};
	char* pho[] = {"Ta Quang Buu", "Tran Dai Nghia", "Le Thanh Nghi", "Tran Hung Dao", "Tay Son", "Thai Ha", "Thanh Xuan", "Quang Trung", "Nguyen Trai", "Hai Ba Trung"};
	char* dauSDT[] = {"098", "016", "097", "012", "088"};

	//char* hour[] = {"06", "07", "08", "17", "18"};
//	char* minute[] = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
//	char* day[] = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
//	char* month[] = {"00", "01", "02", "03", "04", "05","06","07","08","09","10","11","12"};

	FILE* f = fopen("ThongTinNhanVien.txt", "w");


	int ct1 = 0, ct2 = 0, p = 0, count1 = 0, count2 = 0;
	//Mã nhân viên từ 1 đến 100
	for(int i = 1; i <= 100; i++)
	{
		fprintf(f, "NV%d\n", i);

		char* HD = hoDem[rand() % (sizeof(hoDem) / sizeof(char*))];
		fprintf(f, "%s\n", HD);

		char* T = ten[rand() % (sizeof(ten) / sizeof(char*))];
		fprintf(f, "%s\n", T);

		if (i > 42){
            fprintf(f, "%s - %s\n", phong[rand() % (sizeof(phong) / sizeof(char*))],
                                    congTy[rand() % (sizeof(congTy) / sizeof(char*))]);
            fprintf(f, "Nhan vien\n");
            }
            else if (i < 2){
                fprintf(f,"BK Corporation\n");
                fprintf(f,"Chu tich\n");
            }
            else if (i < 4){
                fprintf(f,"BK Corporation\n");
                fprintf(f,"Pho chu tich\n");
            }
            else if (i < 13){
                fprintf(f,"%s\n",congTy[ct1]);
                count1++;
                if (count1 > 3) count1 = 1;
                if (count1 < 2) fprintf(f,"Giam doc\n");
                    else if (count1 < 4) fprintf(f,"Pho giam doc\n");
                if (count1 == 3) ct1++;
            }
            else{
                count2++;
                if (count2 > 2){
                    count2 = 1;
                    p++;
                }
                if (p > 4){
                    p = 0;
                    ct2++;
                }
                fprintf(f,"%s - %s\n", phong[p], congTy[ct2]);
                if (count2 == 1) fprintf(f,"Truong phong\n");
                    else if (count2 == 2) fprintf(f,"Pho phong\n");
            }


		fprintf(f, "%d/%d/%d\n", rand() % 28 + 1, rand() % 12 +1, rand() % 40 + 1955);

		fprintf(f, "%s\n", tinhThanh[rand() % (sizeof(tinhThanh) / sizeof(char*))]);

		fprintf(f, "So %d, %s\n", rand() % 100 + 1, pho[rand() % (sizeof(pho) / sizeof(char*))]);

		fprintf(f, "%s@gmail.com\n", createEmail(HD, T));

		fprintf(f,"%s%d%d%d%d%d%d%d\n", dauSDT[rand() % (sizeof(dauSDT) / sizeof(char*))],
                                        rand()%10, rand()%10, rand()%10, rand()%10, rand()%10, rand()%10, rand()%10);

		ngay = rand() % 28 + 1;
		thang = rand() % 12 + 1;
		nam = rand() % 7 + 2010;
		fprintf(f,"%d/%d/%d\n", ngay, thang, nam);

		ngay = 1; thang = 3; nam = 2018;
		while(1)
		{
			plusDate();
			int weekday = dayofweek(nam, thang, ngay);
				if (weekday == 6 || weekday == 0)
					continue;
			if (rand() % 20 == 0) continue;
			if (check())
				fprintf(f, "%02d/%02d/%d, %02d:%02d, %02d:%02d\n",
                            ngay, thang, nam, rand() % 2 + 8, rand() % 60, rand() % 2 + 16, rand() % 60 );
													/*	day[ngay],month[thang], nam*/
			else
				break;
		}
	}
	fclose(f);
}
