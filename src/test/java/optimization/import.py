import pandas as pd
from sqlalchemy import create_engine
import pymysql
# from sqlalchemy import create_engine
host = 'localhost'
user = 'root'
password = '187415157'
database = 'test_db'

# 建立到MySQL数据库的连接
conn = pymysql.connect(
    host=host,
    user=user,
    password=password,
    database=database
)

# 读取 CSV 文件
csv_file = 'generated_data.csv'
cursor = conn.cursor()
df = pd.read_csv(csv_file)
mysql_conn_str = 'mysql+pymysql://root:187415157@localhost/test_db'
engine = create_engine(mysql_conn_str)
df[["id","name","age","gender"]].to_sql('user', con=engine, if_exists='append', index=False)
# Close cursor and connection
cursor.close()
conn.close()
# 将数据导入到数据库
# table_name = 'person'
# df.to_sql(table_name, con=conn, if_exists='append', index=False)

print(f"Data from '{csv_file}' has been imported into the '{table_name}' table in the database.")
