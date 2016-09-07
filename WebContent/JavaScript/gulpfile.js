'use strict';

var gulp = require('gulp');
var fs = require("fs");
var browserify = require("browserify");
var babelify = require("babelify");
var source = require('vinyl-source-stream');
var gutil = require('gulp-util');

gulp.task('es6', function(){
    browserify({
            entries: ['src/copytrade.js'],
            debug: true
        })
        .transform(babelify)
        .bundle()
        .on('error', gutil.log)
        .pipe(source('bundle.js'))
        .pipe(gulp.dest('./'));
});

gulp.task('watch', function () {
    gulp.watch(['src/*.js'], ['es6']);
});

gulp.task('default', ['es6', 'watch']);