# Generated by Django 3.0.3 on 2020-10-02 10:12

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Word',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('word', models.CharField(max_length=200)),
            ],
        ),
        migrations.CreateModel(
            name='Video',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('videoUrl', models.TextField(null=True)),
                ('word', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='crawling.Word')),
            ],
        ),
        migrations.CreateModel(
            name='Image',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('imageUrl', models.TextField(null=True)),
                ('word', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='crawling.Word')),
            ],
        ),
    ]