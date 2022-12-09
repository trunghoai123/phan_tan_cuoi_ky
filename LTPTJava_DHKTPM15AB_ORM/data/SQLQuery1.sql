USE [Project_DB]
GO

select * from [dbo].[phones]
select * from [dbo].[employees]
select * from [dbo].[projects]
select * from [dbo].[assignments]

INSERT [dbo].[employees] ([emp_id], [email], [hire_date], [full_name], [manager_id]) VALUES (N'EMP1', N'john.smith@gmail.com', CAST(N'2000-02-01' AS Date), N'John Smith', NULL)
GO
INSERT [dbo].[employees] ([emp_id], [email], [hire_date], [full_name], [manager_id]) VALUES (N'EMP2', N'john.tran@gmail.com', CAST(N'2010-02-01' AS Date), N'John Tran', N'EMP1')
GO
INSERT [dbo].[phones] ([emp_id], [phone]) VALUES (N'EMP1', N'09 345-567')
GO
INSERT [dbo].[phones] ([emp_id], [phone]) VALUES (N'EMP1', N'09 456-789')
GO
INSERT [dbo].[phones] ([emp_id], [phone]) VALUES (N'EMP2', N'09 345-890')
GO
INSERT [dbo].[phones] ([emp_id], [phone]) VALUES (N'EMP2', N'09 789-789')
GO
INSERT [dbo].[phones] ([emp_id], [phone]) VALUES (N'EMP2', N'34 456-764')
GO
INSERT [dbo].[projects] ([prj_id], [budget], [location], [project_name], [start_date]) VALUES (N'PRJ01', CAST(987.45 AS Decimal(10, 2)), N'UAS', N'Database System', CAST(N'2022-12-01' AS Date))
GO
INSERT [dbo].[projects] ([prj_id], [budget], [location], [project_name], [start_date]) VALUES (N'PRJ02', CAST(387.50 AS Decimal(10, 2)), N'UAS', N'Laser Printers', CAST(N'2023-01-01' AS Date))
GO
INSERT [dbo].[assignments] ([emp_id], [prj_id], [hours]) VALUES (N'EMP1', N'PRJ01', 15)
GO
INSERT [dbo].[assignments] ([emp_id], [prj_id], [hours]) VALUES (N'EMP1', N'PRJ02', 25)
GO
INSERT [dbo].[assignments] ([emp_id], [prj_id], [hours]) VALUES (N'EMP2', N'PRJ01', 35)
GO

