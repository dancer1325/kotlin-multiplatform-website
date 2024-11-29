import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func sumArray(input: [Int]) -> String {
           var total = 0
           for item in input {
               total += item
           }
           return "Total value is \(total)"
    }
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(text: sumArray(input: [10,20,30,40]))
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}



