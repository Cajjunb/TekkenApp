/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var gulp = require('gulp');

gulp.task('copy-js-files', function () {
  gulp.src('./node_modules/angular/angular.min.js')
   .pipe(gulp.dest('./dist/js'));
  gulp.src('./node_modules/angular-ui-boostrap/angular-ui-boostrap.min.js')
   .pipe(gulp.dest('./dist/js'));

});