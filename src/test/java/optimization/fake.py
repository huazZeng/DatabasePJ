import pandas as pd
from faker import Faker
import random

# 初始化 Faker
fake = Faker()

# 性别选项
genders = ['Male', 'Female']

# 生成数据
def generate_data(num_records):
    data = []
    for i in range(1, num_records + 1):
        name = fake.name()
        age = random.randint(18, 80)
        gender = random.choice(genders)
        data.append((i, name, age, gender))
    return data

# 生成 10000 条记录
num_records = 100000
data = generate_data(num_records)

# 将数据转换为 DataFrame
df = pd.DataFrame(data, columns=['id', 'name', 'age', 'gender'])

# 保存为 CSV 文件
df.to_csv('generated_data.csv', index=False)

print(f"{num_records} records have been generated and saved to 'generated_data.csv'")
