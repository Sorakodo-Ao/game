#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"
void test(void)
{	
	printf("******************\n");
	printf("*1.start  0.exist*\n");
	printf("******************\n");

}
void game()
{
	int RandNum = rand()%100 + 1;//����1 - 100�������
	int GuessNumber = 0;//�µ�����
	while(1)
	{
		printf("please guess:");
		scanf("%d", &GuessNumber);
		if(GuessNumber < RandNum)
		{
			printf("The number is small\n");
		}
		else if(GuessNumber > RandNum)
		{
			printf("The number is large\n");
		}
		else if(GuessNumber == RandNum)
		{
			printf("Congratulations, you guessed it right\n");
			break;
		}
	}
	
}
int main()
{	
	int choose = 0;
	srand((unsigned int)time(NULL));
	while(1)
	{
		test();//��ӡ�˵�
		printf("please choose:");
		scanf("%d",&choose);
		if(choose == 1)
			{ 
				game();
				break;
			}
		else if(choose == 0)
			{
				printf("exist game.\n");
				break;
			}
		else 
			{
				printf("input error,please input again.\n");
			}
	}
	system("puase");

	return 0;
}