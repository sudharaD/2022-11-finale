import 'package:flutter/material.dart';
import 'package:assets_audio_player/assets_audio_player.dart';

void main() => runApp(Xylophone());

class Xylophone extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: SafeArea(
          child: Container(
            child: Center(
              child: TextButton(
                onPressed: () {
                  AssetsAudioPlayer.newPlayer().open(
                    Audio('assets/audios/note1.wav'),
                  );
                },
                child: Text('Click Me!'),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
