package 다이나믹프로그래밍;

import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String resultSongName = "(None)";
        int resultSongPlayedMinutes = 0;

        for (int i = 0; i < musicinfos.length; i++) {
            String[] currentMusicInfo = musicinfos[i].split(",");
            String startTime = currentMusicInfo[0];
            String endTime = currentMusicInfo[1];
            int totalPlayedMinutes = calculatePlayedMinutes(startTime, endTime);
            String title = currentMusicInfo[2];
            String songMelody = currentMusicInfo[3];
            int songMelodyLength = calculateLengthOfSongMelody(songMelody);
            StringBuilder playedMelodySb = new StringBuilder();

            for (int j = 0; j < totalPlayedMinutes / songMelodyLength; j++) {
                playedMelodySb.append(songMelody);
            }
            for (int j = 0; j < totalPlayedMinutes % songMelodyLength; j++) {
                if (j + 1 < playedMelodySb.length() && playedMelodySb.charAt(j + 1) == '#') {
                    playedMelodySb.append(songMelody.substring(j, j + 2));
                    j++;
                } else {
                    playedMelodySb.append(songMelody.charAt(j));
                }
            }
            System.out.println(playedMelodySb);

            // :outerLoop
            // for(int j = 0; j < playedMelodySb.length(); j++) {
            //     if(playedMelodySb.chatAt(j) == m.charAt(0) && j + m.length() <= playedMelodySb.length()) {
            //         for(int k = 0; k < m.length(); k++) {
            //             if(playedMelodySb.charAt(j + k) != m.charAt(k)) {
            //                 continue outerLoop;
            //             }
            //         }
            //         //
            //     }
            // }

            while (playedMelodySb.indexOf(m) != -1) {
                int melodyStartIndex = playedMelodySb.indexOf(m);
                int melodyEndIndex = melodyStartIndex + m.length() - 1;

                if ((melodyEndIndex == playedMelodySb.length() - 1) || (playedMelodySb.charAt(melodyEndIndex + 1) != '#')) {
                    if (resultSongName == null || (resultSongName != null && resultSongPlayedMinutes < totalPlayedMinutes)) {
                        resultSongName = title;
                        resultSongPlayedMinutes = totalPlayedMinutes;
                        break;
                    }
                } else {
                    playedMelodySb.delete(0, melodyEndIndex + 1);
                }
            }
        }

        return resultSongName;
    }

    private int calculatePlayedMinutes(String startTime, String endTime) {
        int playedHours = Integer.parseInt(endTime.substring(0, 2))
                - Integer.parseInt(startTime.substring(0, 2));
        int playedMinutes = Integer.parseInt(endTime.substring(3, 5))
                - Integer.parseInt(startTime.substring(3, 5));

        return (playedHours * 60) + playedMinutes;
    }

    private int calculateLengthOfSongMelody(String songMelody) {
        int countOfSharp = 0;

        for (int i = 0; i < songMelody.length(); i++) {
            if (songMelody.charAt(i) == '#') {
                countOfSharp++;
            }
        }

        return songMelody.length() - countOfSharp;
    }
}