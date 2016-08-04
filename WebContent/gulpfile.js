/* gulpfile.js */
var gulp = require('gulp'),
    sass = require('gulp-sass'),
    nunjucksRender = require('gulp-nunjucks-render'),
    nunjucks = require('nunjucks');

// source and distribution folder
var source = 'src/',
    dest = 'views/';

// Bootstrap scss source
var bootstrapSass = {
        in: './node_modules/bootstrap-sass/'
    };

// Bootstrap fonts source
var fonts = {
        in: [source + 'fonts/*.*', bootstrapSass.in + 'assets/fonts/**/*'],
        out: dest + 'fonts/'
    };

// Our scss source folder: .scss files
var scss = {
    in: source + 'scss/main.scss',
    out: dest + 'css/',
    watch: source + 'scss/**/*',
    sassOpts: {
        outputStyle: 'nested',
        precison: 3,
        errLogToConsole: true,
        includePaths: [bootstrapSass.in + 'assets/stylesheets']
    }
};

// copy bootstrap required fonts to dest
gulp.task('fonts', function () {
    return gulp
        .src(fonts.in)
        .pipe(gulp.dest(fonts.out));
});


// compile scss
gulp.task('sass', ['fonts'], function () {
    return gulp.src(scss.in)
        .pipe(sass(scss.sassOpts))
        .pipe(gulp.dest(scss.out));
});

// compile html templates
gulp.task('nunjucks', function () {
  return gulp.src('src/pages/*.html')
    .pipe(nunjucksRender({
      path: ['src/templates'], // String or Array
      envOptions: {
          tags: {
            variableStart: '<$',
            variableEnd: '$>'
          }
      }
    }))
    .pipe(gulp.dest(dest));
});

// watch sass files
gulp.task('watch', ['sass'], function () {
     gulp.watch(scss.watch, ['sass'])
});

// default task
gulp.task('default', ['nunjucks', 'sass']);