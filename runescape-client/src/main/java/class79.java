import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cd")
public class class79 extends Node {
   @ObfuscatedName("g")
   int[] field1295;
   @ObfuscatedName("y")
   int[] field1298;
   @ObfuscatedName("r")
   boolean field1299;
   @ObfuscatedName("c")
   int[] field1300;
   @ObfuscatedName("p")
   int[] field1301;
   @ObfuscatedName("w")
   int field1302;
   @ObfuscatedName("z")
   int[] field1303;
   @ObfuscatedName("q")
   int field1304;
   @ObfuscatedName("l")
   int field1306;
   @ObfuscatedName("e")
   boolean field1307 = false;
   @ObfuscatedName("x")
   static int[] field1308;

   class79(Buffer var1) {
      this.field1302 = var1.readUnsignedShort();
      this.field1299 = var1.readUnsignedByte() == 1;
      int var2 = var1.readUnsignedByte();
      if(var2 >= 1 && var2 <= 4) {
         this.field1300 = new int[var2];

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            this.field1300[var3] = var1.readUnsignedShort();
         }

         if(var2 > 1) {
            this.field1301 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1301[var3] = var1.readUnsignedByte();
            }
         }

         if(var2 > 1) {
            this.field1295 = new int[var2 - 1];

            for(var3 = 0; var3 < var2 - 1; ++var3) {
               this.field1295[var3] = var1.readUnsignedByte();
            }
         }

         this.field1303 = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.field1303[var3] = var1.method2995();
         }

         this.field1304 = var1.readUnsignedByte();
         this.field1306 = var1.readUnsignedByte();
         this.field1298 = null;
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("n")
   boolean method1572(double var1, int var3, class182 var4) {
      int var5;
      for(var5 = 0; var5 < this.field1300.length; ++var5) {
         if(var4.method3336(this.field1300[var5]) == null) {
            return false;
         }
      }

      var5 = var3 * var3;
      this.field1298 = new int[var5];

      for(int var6 = 0; var6 < this.field1300.length; ++var6) {
         int var8 = this.field1300[var6];
         ModIcon var7;
         if(!ItemLayer.method1489(var4, var8)) {
            var7 = null;
         } else {
            var7 = Sequence.method3829();
         }

         var7.method4134();
         byte[] var10 = var7.pixels;
         int[] var11 = var7.palette;
         int var12 = this.field1303[var6];
         if((var12 & -16777216) == 16777216) {
            ;
         }

         if((var12 & -16777216) == 33554432) {
            ;
         }

         int var13;
         int var14;
         int var15;
         int var16;
         if((var12 & -16777216) == 50331648) {
            var13 = var12 & 16711935;
            var14 = var12 >> 8 & 255;

            for(var15 = 0; var15 < var11.length; ++var15) {
               var16 = var11[var15];
               if((var16 & '\uffff') == var16 >> 8) {
                  var16 &= 255;
                  var11[var15] = var13 * var16 >> 8 & 16711935 | var14 * var16 & '\uff00';
               }
            }
         }

         for(var13 = 0; var13 < var11.length; ++var13) {
            var11[var13] = class84.method1673(var11[var13], var1);
         }

         if(var6 == 0) {
            var13 = 0;
         } else {
            var13 = this.field1301[var6 - 1];
         }

         if(var6 == 0) {
            ;
         }

         if(var13 == 0) {
            if(var7.originalWidth == var3) {
               for(var14 = 0; var14 < var5; ++var14) {
                  this.field1298[var14] = var11[var10[var14] & 255];
               }
            } else if(var7.originalWidth == 64 && var3 == 128) {
               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1298[var14++] = var11[var10[(var16 >> 1) + (var15 >> 1 << 6)] & 255];
                  }
               }
            } else {
               if(var7.originalWidth != 128 || var3 != 64) {
                  throw new RuntimeException();
               }

               var14 = 0;

               for(var15 = 0; var15 < var3; ++var15) {
                  for(var16 = 0; var16 < var3; ++var16) {
                     this.field1298[var14++] = var11[var10[(var16 << 1) + (var15 << 1 << 7)] & 255];
                  }
               }
            }
         }

         if(var13 == 1) {
            ;
         }

         if(var13 == 2) {
            ;
         }

         if(var13 == 3) {
            ;
         }
      }

      return true;
   }

   @ObfuscatedName("d")
   void method1573() {
      this.field1298 = null;
   }

   @ObfuscatedName("m")
   void method1574(int var1) {
      if(this.field1298 != null) {
         short var2;
         int var3;
         int var4;
         int var5;
         int var6;
         int var7;
         int[] var10;
         if(this.field1304 == 1 || this.field1304 == 3) {
            if(field1308 == null || field1308.length < this.field1298.length) {
               field1308 = new int[this.field1298.length];
            }

            if(this.field1298.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1298.length;
            var4 = var2 * var1 * this.field1306;
            var5 = var3 - 1;
            if(this.field1304 == 1) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; ++var6) {
               var7 = var6 + var4 & var5;
               field1308[var6] = this.field1298[var7];
            }

            var10 = this.field1298;
            this.field1298 = field1308;
            field1308 = var10;
         }

         if(this.field1304 == 2 || this.field1304 == 4) {
            if(field1308 == null || field1308.length < this.field1298.length) {
               field1308 = new int[this.field1298.length];
            }

            if(this.field1298.length == 4096) {
               var2 = 64;
            } else {
               var2 = 128;
            }

            var3 = this.field1298.length;
            var4 = var1 * this.field1306;
            var5 = var2 - 1;
            if(this.field1304 == 2) {
               var4 = -var4;
            }

            for(var6 = 0; var6 < var3; var6 += var2) {
               for(var7 = 0; var7 < var2; ++var7) {
                  int var8 = var6 + var7;
                  int var9 = var6 + (var7 + var4 & var5);
                  field1308[var8] = this.field1298[var9];
               }
            }

            var10 = this.field1298;
            this.field1298 = field1308;
            field1308 = var10;
         }

      }
   }
}
